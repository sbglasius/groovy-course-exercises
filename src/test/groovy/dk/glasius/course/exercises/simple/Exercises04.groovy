package dk.glasius.course.exercises.simple

import spock.lang.Specification


class Exercises04 extends Specification {

    String[] array = ['a', 'b', 'c', 'd']

    def "indexing in arrays"() {
        expect: 'the size'
            array.size() == 4
        and: 'get first element'
            array[0] == 'a'
        and: 'how about last element?'
            array[-1] == 'd'
        and: 'second last element?'
            array[-2] == 'c'
        and: 'last two elements?'
            array[-2..-1] == ['c', 'd']
        and: 'last three elements in reverse order?'
            array[-1..-3] == ['d', 'c', 'b']
    }

    def "indexing in arrays II"() {
        when: 'addressing non existing indexes'
            array[10]
        then: 'catch the exception thrown'
            def e = thrown(Exception)
        and: 'what is it expected to be?'
            e.getClass().is ArrayIndexOutOfBoundsException
    }

    def "methods on arrays"() {
        given: 'an array'
            def numbers = [29, 7, 13, 3, 19, 9, 23, 11]
        expect: 'the lowest number'
            numbers.min() == 3
        and: 'the highest number'
            numbers.max() == 29
        and: 'the sum'
            numbers.sum() == 114
        and: 'the average'
            numbers.sum() / numbers.size() == 14.25
        and: 'the first number greater than 10'
            numbers.sort().find { it >= 10 } == 11
    }}
