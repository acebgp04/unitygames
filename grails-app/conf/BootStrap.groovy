import org.unity.Category
import org.unity.Player
import org.unity.Sport
import org.unity.Team

class BootStrap {

    def init = { servletContext ->
        def adminRole = new org.unity.security.Role(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new org.unity.security.Role(authority: 'ROLE_USER').save(flush: true)

        def testUser = new org.unity.security.User(username: 'admin', enabled: true, password: 'admin')
        testUser.save(flush: true)

        org.unity.security.UserRole.create testUser, adminRole, true

        String path = !System.properties['os.name'].toLowerCase().contains('windows') ? "/Users/ace/Documents/Master File.xlsx" : "C:\\MASTER FILE (1).xls"
        Import importer = new Import(path)
        def booksMapList = importer.getBooks();
        booksMapList.each { Map playerParams ->

            Sport sport = Sport.findByName(playerParams.get('sport')?.trim()) ? Sport.findByName(playerParams.get('sport')?.trim()) : new Sport(name:playerParams?.get('sport')?.trim()).save(flush: true)
            Category category = Category.findByName(playerParams.get('category')?.trim()) ? Category.findByName(playerParams.get('category')?.trim()) : new Category(name: playerParams.get('category')?.trim()).save(flush: true)
            category?.setSport(sport)
            category?.save(flush: true)
            new Player(controlNo: "${playerParams.get('controlNo')}",
                       sport: sport,
                       category: category,
                       team: Team.findByName(playerParams.get('team')) ?: new Team(name:playerParams.get('team')).save(flush: true),
                       fullName: playerParams.get('fullName'),
                       kapisanan: playerParams.get('kapisanan'),
                       lokal: playerParams.get('lokal'),
                       district: playerParams.get('distrito'),
                       gender: playerParams.get('gender'),
                       remarks: playerParams.get('remarks')
            ).save(flush: true, failOnError: true)


        }
        println Team.list()
        println booksMapList.size()
        println Player.list().size()
    }
    def destroy = {
    }
}
