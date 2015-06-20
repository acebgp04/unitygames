package unitygamesv2

import org.unity.Player

import javax.transaction.Transactional

/**
 * PlayerService
 * A service class encapsulates the core business logic of a Grails application
 */
@Transactional
class PlayerService {

    def complist(params){
        def clist = Player.createCriteria().list{
            or {
                ilike("fullName", "%${params.term}%")
            }
        } // execute  to the get the list of companies
        println(clist)
        def companySelectList = [] // to add each company details
        clist.each { Player player ->
            def companyMap = [:] // add to map. jQuery autocomplete expects the JSON object to be with id/label/value.
            companyMap.put("id", player.id)
            companyMap.put("label", player.fullName)
            companyMap.put("value", player.fullName)
            companyMap.put("nasSymbol", player.fullName) // will use this to pre-populate the Emp Id
            companySelectList.add(companyMap) // add to the arraylist
        }
        println(companySelectList.size())
        if(companySelectList.size() == 0) {
            def companyMap = [:] // add to map. jQuery autocomplete expects the JSON object to be with id/label/value.
            companyMap.put("id", 0)
            companyMap.put("label", "Player not Found!")
            companyMap.put("value", "Player not Found!")
            companyMap.put("nasSymbol", "Player not Found!") // will use this to pre-populate the Emp Id
            companySelectList.add(companyMap) // add to the arraylist
        }
        return companySelectList
    }
}
