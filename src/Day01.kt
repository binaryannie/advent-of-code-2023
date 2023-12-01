private const val DAY = "01"
private const val PART_1_CHECK = 142
private const val PART_2_CHECK = 281

val digitMap = mapOf(
    "one" to "1",
    "two" to "2",
    "three" to "3",
    "four" to "4",
    "five" to "5",
    "six" to "6",
    "seven" to "7",
    "eight" to "8",
    "nine" to "9"
)

fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf {
            val digits = it.filter { c -> c.isDigit() }
            (digits.first().toString() + digits.last()).toInt()
        }
    }

    fun part2(input: List<String>): Int {
        return input.sumOf {
            val digits = Regex("(?=([1-9]|one|two|three|four|five|six|seven|eight|nine))")
                .findAll(it)
                .map { m -> m.groupValues[1] }.toList()
                .map { s -> if (digitMap.containsKey(s)) digitMap[s] else s }
            (digits.first() + digits.last()).toInt()
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day${DAY}_test")
    check(part1(testInput).also { println("Part 1 check: $it") } == PART_1_CHECK)
    check(part2(testInput).also { println("Part 2 check: $it") } == PART_2_CHECK)


    val input = readInput("Day${DAY}")
    println("Part 1 solution: ${part1(input)}")
    println("Part 2 solution: ${part2(input)}")
}