package dk.glasius.course.exercises.simple

import spock.lang.Specification
import spock.lang.Unroll

/**
 * See http://groovy-lang.org/closures.html
 */
class Exercises03 extends Specification {
    def "simple closure"() {
        given: 'Define a closure that takes one argument'
            def closure = {  }
        when: 'called with a number'
            def result = closure.call(3)
        then: 'returns the number multiplied by itself'
            result == 9
    }

    def "simple closure II"() {
        given: 'Define a closure that takes two arguments'
            def closure = { }
        when: 'called with two numbers'
            def result = closure.call(3, 4)
        then: 'returns the numbers multiplied '
            result == 12
    }

    def "simple closure III"() {
        given: 'Define a closure that takes one or two arguments'
            def closure = { }
        when: 'called with one number'
            def result = closure.call(3)
        then: 'returns the number multiplied by it self '
            result == 9
        when: 'called with two numbers'
            result = closure.call(3, 4)
        then: 'returns the numbers multiplied '
            result == 12
    }

    @Unroll
    def "Simple closure IV"() {
        given: 'Define a closure that takes n strings'
            def closure = { }
        when: 'called with an abirary number of args'
            def result = closure.call(args as String[])
        then: 'we expect this result'
            result == expected
        where:
            args                  || expected
            ['a']                 || 'a'
            ['a', 'b']            || 'ab'
            ['a', 'b', 'c']       || 'abc'
            ['abc', 'd']          || 'abcd'
            [1, 2, 3]             || '123'
            [1, 2, 3, 4, 5, 6, 7] || '1234567'
            (1..9)                || '123456789'
    }

    def "closure delegates"() {
        given:
            def closure = {
                firstName = "John"
                lastName = "Doe"
            }
        and: 'the delegate is assigned to what?'
            closure.delegate = this // Change here

        when: 'when calling the closure'
            closure.call()
        then: 'then the delegate will return'
            closure.delegate.toString() == 'John Doe'
    }

    static class Person {
        String firstName
        String lastName

        String toString() { "$firstName $lastName" }
    }
}
