package tdd.quadratic.baskara

import java.math.BigDecimal
import java.math.MathContext

class Baskara {
    fun calculate(a: BigDecimal, b: BigDecimal, c: BigDecimal): Set<BigDecimal> {
        val twoTimesA = a.multiply(BigDecimal(2))
        val delta = Delta.calculate(a,b,c)

        try {
            val squareRootDelta = delta.sqrt(MathContext(10))
            val minusB = b.negate()

            return setOf(
                minusB.plus(squareRootDelta).divide(twoTimesA),
                minusB.minus(squareRootDelta).divide(twoTimesA)
            )
        } catch(e: ArithmeticException){
            return emptySet()
        }


    }
}