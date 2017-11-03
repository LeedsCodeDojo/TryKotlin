package dojo.leeds.problem2

fun fizzBuzzValue(n:Int) = when {
    n % 15 == 0-> "Fizz Buzz"
    n % 5 == 0-> "Buzz"
    n % 3 == 0-> "Fizz"
    else -> n.toString()
}

fun fizzBuzz(n: Int) = (1..n).map { fizzBuzzValue(it) }