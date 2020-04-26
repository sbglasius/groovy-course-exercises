package dk.glasius.course.exercises.simple

import spock.lang.Specification


class Exercises04 extends Specification {

    String[] array = ['a', 'b', 'c', 'd']

    def "indexing in arrays"() {
        expect: 'the size'
            array.m() == 4
        and: 'get first element'
            array == 'a'
        and: 'how about last element?'
            array == 'd'
        and: 'second last element?'
            array == 'c'
        and: 'last two elements?'
            array == ['c', 'd']
        and: 'last three elements in reverse order?'
            array == ['d', 'c', 'b']
    }

    def "indexing in arrays II"() {
        when: 'addressing non existing indexes'
            array[10]
        then: 'catch the exception thrown'
            def e = thrown(Exception)
        and: 'what is it expected to be?'
            e.getClass().is Exception
    }

    def "methods on arrays"() {
        given: 'an array'
            def numbers = [29, 7, 13, 3, 19, 9, 23, 11]
        expect: 'the lowest number'
            numbers.x() == 3
        and: 'the highest number'
            numbers.x() == 29
        and: 'the sum'
            numbers.x() == 114
        and: 'the average'
            numbers.x() / numbers.x() == 14.25
        and: 'the first number greater than 10'
            numbers.x().y {  } == 11
    }
}
