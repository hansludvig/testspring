package com.example.hans.batchprocessing

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.item.ItemProcessor

class PersonItemProcessor: ItemProcessor<Person, Person>  {

    private val log: Logger = LoggerFactory.getLogger(PersonItemProcessor::class.java)

    override fun process(item: Person): Person? {
        val firstName: String = item.firstName.uppercase()
        val lastName: String = item.lastName.uppercase()

        val transformedPerson = Person(firstName, lastName)

        log.info("Converting ($item) into ($transformedPerson)")

        return transformedPerson
    }
}