package dk.glasius.course.exercises.simple

import spock.lang.Specification

/**
 * See: https://docs.groovy-lang.org/latest/html/documentation/#Collections-Lists
 */
class Exercises05 extends Specification {

    List<String> list = ['Groovy', 'Grails', 'Gradle', 'Griffon', 'Spring Boot', 'Java']

    def "empty list"() {
        given: 'an emtpy list'
            List emptyList = []
        expect: 'e_press the boolean value of a list'
            false // Make a simple e_pression
        and: 'determin if a list is empty'
            emptyList._ // What property or method on emptyList
    }

    def "list type"() {
        expect: 'what default type does the list have?'
            list.getClass().is(Object)
    }

    def "inde_ing in list"() {
        expect: 'the size'
            list._() == 6
        and: 'get first element'
            list[_] == 'Groovy'
            list._() == 'Groovy'
        and: 'how about last element?'
            list[_] == 'Java'
            list._() == 'Java'
        and: 'second last element?'
            list[_] == 'Spring Boot'
        and: 'last two elements?'
            list[_] == ['Groovy', 'Spring Boot', 'Java']
    }

    def "inde_ing in lists II"() {
        when: 'addressing non e_isting inde_es'
            def result = list[10]
        then: 'expect what?'
            result == '?' // What is the expected outcome?
    }

    def "manipulating a list"() {
        when: 'adding an element to a list (in various ways)'
            list << 'JEE'
            list += 'Kotlin'
            list += ['Spring Framework', 'Kafka', 'Camel']

        then: 'what is the content of the list now?'
            list == ['?']

        when: 'We got one too many in the list, how to remove it'
            list -= 'Kotlin'

        then: 'what is the content of the list now?'
            list == ['?']

        when: 'We add e_isting elements to the list'
            list += ['Groovy', 'Grails']

        then: 'what is the content of the list now?'
            list == ['?'] // And why

        and: 'removing dupplicates how?'
            list._() == ['Groovy', 'Grails', 'Gradle', 'Griffon', 'Spring Boot', 'Java', 'JEE', 'Spring Framework', 'Kafka', 'Camel']

    }

    def "methods on list"() {
        given: 'a simple list of numbers'
            List<Integer> numbers = [29, 7, 13, 3, 19, 9, 23, 11]
        expect: 'the lowest number'
            numbers._() == 3
        and: 'the highest number'
            numbers._() == 29
        and: 'the sum'
            numbers._() == 114
        and: 'the average'
            numbers._() / numbers._() == 14.25
        and: 'the first number greater than 10'
            numbers._().y { } == 11
    }

    def "more methods on list"() {
        expect: 'alphabetically sorted list of technologies (mind the sideeffect)'
            list._() == ['Gradle', 'Grails', 'Griffon', 'Groovy', 'Java', 'Spring Boot']
        and: 'sorted by string size'
            list._ {  } == ['Java', 'Groovy', 'Grails', 'Gradle', 'Griffon', 'Spring Boot']
        and: 'sorted by string size and then alphabetically'
            list._ {  } == ['Java', 'Gradle', 'Grails', 'Groovy', 'Griffon', 'Spring Boot']
        and: 'technologies with G joined with comma'
            list._ {  }._(',') == 'Groovy,Grails,Gradle,Griffon'
    }

    def "more advanced methods on lists"() {
        expect: 'the list with each tech in upper case'
            list._ { _ } == ['GROOVY', 'GRAILS', 'GRADLE', 'GRIFFON', 'SPRING BOOT', 'JAVA']

        and: 'grouping by first letter in name'
            list._ { _ } == [G: ['Groovy', 'Grails', 'Gradle', 'Griffon'], J: ['Java'], S: ['Spring Boot']]
    }

}
