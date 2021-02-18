package dk.glasius.course.exercises.simple

import org.codehaus.groovy.runtime.GStringImpl
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See http://groovy-lang.org/syntax.html#all-strings
 */
class Exercises01 extends Specification {

    @Unroll
    def 'Types of String classes'() {
        expect:
            string.getClass().is(clazz)
        where:
            string     || clazz
            'a'        || String
            "a"        || String
            '${1}'     || String
            "${1}"     || GStringImpl
            '''a'''    || String
            '''${1}''' || String
            """a"""    || String
            """${1}""" || GStringImpl
            /${1}/     || GStringImpl
            /$1/       || String
            $/${1}/$   || GStringImpl
            $/$$1/$    || String
    }

    def 'How to handle chars'() {
        given: "Fix this statement"
            char c = 'A'

        expect: "So that this does not fail"
            c instanceof Character
    }

    def 'Testing GStrings'() {
        given: 'Two variables'
            def number = 42
            def what = 'life, the Universe and everything'
        and: 'A GString'
            def gstring = "$number is the answer to $what"

        expect: 'the answer to be'
            gstring == '42 is the answer to life, the Universe and everything'

        when: 'changing the number'
            number = 45

        then: 'what will the right value for the gstring?'
            gstring == '42 is the answer to life, the Universe and everything'
    }

    def 'Testing GStrings lazy evaluation'() {
        given: 'A variable'
            def a = 1
        and: 'A GString'
            def gstring = "a is ${->a}"

        expect: 'the evaluation of the GString should be'
            gstring == 'a is 1'

        when: 'changing a'
            a = 2

        then: 'without changing the gstring, the evaluation of the GString should be'
            gstring == 'a is 2'
    }

    def 'repeat a string'() {
        expect: 'a Groovy way to repeat a string'
            '*-*'.multiply(10)  == '*-**-**-**-**-**-**-**-**-**-*'
    }

    def 'remove part of a string'() {
        expect: 'an intuitive way to remove part of a string'
        'This is NOT Groovy' - 'NOT ' == 'This is Groovy'
    }

    @Unroll
    def 'align a string'() {
        expect: 'a Groovy way to pad a string'
            "$number".padLeft(5) == output

        where: 'data is taken from this table'
            number || output
            1      || '    1'
            10     || '   10'
            100    || '  100'
            1000   || ' 1000'
            10000  || '10000'
    }

    def 'an easy way to make a string with multiple lines indented right'() {
        expect: 'a multiline string to produce the right output'
            '''
            <x>
                <y>Z</y>
            </x>
            '''.stripIndent().trim() == '<x>\n    <y>Z</y>\n</x>'
    }

    def 'Hashing strings'() {
        expect: 'This is true'
            "Value: ${1}" == 'Value: 1'
        and: 'This is not true, because GStrings have a different hashCode() implementation ' +
                '- even if resulting strings are equal'
            "Value: ${1}".hashCode() != 'Value: 1'.hashCode()
    }

}
