package dk.glasius.course.exercises.simple

import spock.lang.Specification
import spock.lang.Unroll

import java.util.function.DoubleToLongFunction

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
            1                   || Integer | 'default integer type = Integer'
            2147483647          || Integer | 'just within Integer range'
            2147483648          || Long | 'just outside Integer range'
            9223372036854775807 || Long | 'just within Long range'
            9223372036854775808 || BigInteger | 'just outside Long range; BigInteger has unlimited range'
            1.0                 || BigDecimal | 'default type with decimals = BigDecimal'
            1.1 + 1.0           || BigDecimal | 'default type with decimals = BigDecimal'
            1.2 + 1.0f          || Double | '(1) both operands are floating point, so defaults to double'
            1.3f + 1.0          || Double | '(2), both operands are floating point, so defaults to double'
            1.4 + 1.0d          || Double | '(3), both operands are floating point, so defaults to double'
            1.5d + 1.0          || Double | '(4), both operands are floating point, so defaults to double'
    }

    def "make the numbers add up"() {
        expect: 'floating numbers does not have infinit precision. Groovy to the rescue'
            1.1 + 1.0 == 2.1
    }

    def "Going from strings to numbers"() {
        expect: 'Convert to Integer (in a Groovy way!)'
            "1" as int == 1i
        and: 'to Long'
            "1" as long == 1l
        and: 'to BigInteger'
            "1" as BigInteger == 1g
        and: 'to Float'
            "1.1" as float == 1.1f
        and: 'to Double'
            "1.1" as double == 1.1d
        and: 'to BigDecimal'
            "1.1" as BigDecimal == 1.1g
    }
}
