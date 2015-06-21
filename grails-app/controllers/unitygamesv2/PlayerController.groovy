package unitygamesv2

import grails.converters.JSON
import grails.transaction.Transactional
import org.springframework.web.multipart.commons.CommonsMultipartFile
import org.unity.Category
import org.unity.Player
import org.unity.Sport
import org.unity.Team

import static org.springframework.http.HttpStatus.*

/**
 * PlayerController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
@Transactional(readOnly = true)

class PlayerController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def playerService

    def complist = {
        render playerService.complist(params) as JSON
    }
    def findCategoriesBySport = {
        def categories = Category.findAllBySport(Sport.get(params.sport));
        render(template: 'categories', model:  [categories: categories])
    }
	def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Player.list(params), model:[playerInstanceCount: Player.count()]
    }

	def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Player.list(params), model:[playerInstanceCount: Player.count()]
    }

    def show(Player playerInstance) {
        respond playerInstance
    }

    def create() {
        respond new Player(params)
    }

    @Transactional
    def save(Player playerInstance) {
        if (playerInstance == null) {
            notFound()
            return
        }

        if (playerInstance.hasErrors()) {
            respond playerInstance.errors, view:'create'
            return
        }

        def file = params.pictureFile
        if(file?.size != 0 && file != null) {
            def userDir = new File(!System.properties['os.name'].toLowerCase().contains('windows') ? "/Users/ace/Documents" : "C:\\", "/payload/${playerInstance?.team?.name}")
            userDir.mkdirs()
            def ext = file?.originalFilename?.toString()?.lastIndexOf('.')
            File fileNew =  new File( userDir, "${playerInstance?.fullName}${ext}")
            file?.transferTo(fileNew)
            playerInstance.picture = fileNew.getAbsolutePath()
        }
        playerInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'playerInstance.label', default: 'Player'), playerInstance.id])
                redirect playerInstance
            }
            '*' { respond playerInstance, [status: CREATED] }
        }
    }

    def edit(Player playerInstance) {
        respond playerInstance
    }

    @Transactional
    def update(Player playerInstance) {
        if (playerInstance == null) {
            notFound()
            return
        }

        if (playerInstance.hasErrors()) {
            respond playerInstance.errors, view:'edit'
            return
        }

        playerInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Player.label', default: 'Player'), playerInstance.id])
                redirect playerInstance
            }
            '*'{ respond playerInstance, [status: OK] }
        }
    }
    @Transactional
    def upload() {
        println 'test'
        def fileName
        def inputStream
        if (params.qqfile instanceof CommonsMultipartFile) {
            fileName = params.qqfile?.originalFilename
            inputStream = params.qqfile.getInputStream()
        } else {
            fileName = params.qqfile
            inputStream = request.getInputStream()
        }
        //To avoid problems with spaces
        fileName = fileName.toString()
        def ext = fileName.substring(fileName?.lastIndexOf('.'), fileName.length())
        Player player = Player.get(params.player)
        Team team = player.getTeam()
        def userDir = new File(!System.properties['os.name'].toLowerCase().contains('windows') ? "/Users/ace/Documents" : "C:\\", "/payload/${team?.name}")
        userDir.mkdirs()
        File storedFile = new File(userDir, player?.fullName+ext)

        player?.setPicture(storedFile?.getAbsolutePath())
        player.save(flush: true)

        storedFile.append(inputStream)
        def result = [fileName] as JSON
        redirect action: show(player)
    }
    @Transactional
    def delete(Player playerInstance) {

        if (playerInstance == null) {
            notFound()
            return
        }

        playerInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Player.label', default: 'Player'), playerInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'playerInstance.label', default: 'Player'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
