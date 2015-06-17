class BootStrap {

    def init = { servletContext ->
        def adminRole = new org.unity.security.Role(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new org.unity.security.Role(authority: 'ROLE_USER').save(flush: true)

        def testUser = new org.unity.security.User(username: 'admin', enabled: true, password: 'admin')
        testUser.save(flush: true)

        org.unity.security.UserRole.create testUser, adminRole, true

        Import importer = new Import("/Users/ace/Documents/Workbook3.xls")
        def booksMapList = importer.getBooks();
        booksMapList.each { Map bookParams ->
            println(bookParams)
        }
    }
    def destroy = {
    }
}
