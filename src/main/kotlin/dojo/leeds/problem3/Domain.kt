package dojo.leeds.problem3

data class Address (val line1: String, val line2: String, val line3: String?, val line4: String?, val county: String, val postCode: String )

data class Company (val companyName: String, val headOffice: Address )

data class Person (val firstName: String, val surname: String, val age: Int, val employer: Company )