package dk.glasius.course.exercises.simple

import spock.lang.Specification
import spock.lang.Unroll

/**
 * See http://groovy-lang.org/syntax.html#_numbers
 */
class Exercises02 extends Specification {
    @Unroll
    def "number types #description"() {
        expect:
            number.getClass().is(clazz)

        where:
            number              || clazz      | description
            1                   || Integer    | 'Integer'
            2147483647          || Integer    | 'Integer.MAX_VALUE'
            2147483648          || Long       | 'Integer.MAX_VALUE + 1'
            9223372036854775807 || Long       | 'Long.MAX_VALUE'
            9223372036854775808 || BigInteger | 'Long.MAX_VALUE + 1'
            1.0                 || BigDecimal | 'BigDecimal'
            1.1 + 1.0           || BigDecimal | 'BigDecimal + BigDecimal > BigDecimal'
            1.2 + 1.0f          || Double     | 'BigDecimal + Float > Double'
            1.3f + 1.0          || Double     | 'Float + BigDecimal > Double'
            1.4 + 1.0d          || Double     | 'BigDecimal + Double > Double'
            1.5d + 1.0          || Double     | 'Double + BigDecimal > Double'
    }

    def "make the numbers add up"() {
        expect: 'floating numbers does not have infinit precision. Groovy to the rescue'
            1.1 + 1.0 == 2.1
    }

    def "Going from strings to numbers"() {
        expect: 'Convert to Integer (in a Groovy way!)'
            "1" as Integer == 1i
        and: 'to Long'
            "1" as Long == 1l
        and: 'to BigInteger'
            "1" as BigInteger == 1g
        and: 'to Float'
            "1.1" as Float == 1.1f
        and: 'to Double'
            "1.1" as Double == 1.1d
        and: 'to BigDecimal'
            "1.1" as BigDecimal == 1.1g
    }
}
