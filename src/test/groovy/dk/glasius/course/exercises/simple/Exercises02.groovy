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
            number              || clazz  | description
            1                   || Object | '- redacted -'
            2147483647          || Object | '- redacted -'
            2147483648          || Object | '- redacted -'
            9223372036854775807 || Object | '- redacted -'
            9223372036854775808 || Object | '- redacted -'
            1.0                 || Object | '- redacted -'
            1.1 + 1.0           || Object | '- redacted -'
            1.2 + 1.0f          || Object | '- redacted -'
            1.3f + 1.0          || Object | '- redacted -'
            1.4 + 1.0d          || Object | '- redacted -'
            1.5d + 1.0          || Object | '- redacted -'
    }

    def "make the numbers add up"() {
        expect: 'floating numbers does not have infinit precision. Groovy to the rescue'
            1.1F + 1.0F == 2.1F
    }

    def "Going from strings to numbers"() {
        expect: 'Convert to Integer (in a Groovy way!)'
            "1" == 1i
        and: 'to Long'
            "1" == 1l
        and: 'to BigInteger'
            "1" == 1g
        and: 'to Float'
            "1.1" == 1.1f
        and: 'to Double'
            "1.1" == 1.1d
        and: 'to BigDecimal'
            "1.1" == 1.1g
    }
}
