fun main() {

    fun isLineSafe(report: List<Int>): Boolean {
        val differences = report.zipWithNext() { a, b -> a - b }
        return differences.all { it in -3..3 } && (differences.all { it < 0 } || differences.all { it > 0 })
    }

    fun part1(input: List<List<Int>>): Int {
        return input.count(::isLineSafe)
    }

    fun part2(input: List<List<Int>>): Int =
        input.count { report ->
            report.indices.any {
                val skipped = report.toMutableList().apply { removeAt(it) }
                isLineSafe(skipped)
            }
        }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day02_test")
    val testLines = testInput.map { line -> line.split(' ').map(String::toInt) }
    check(part1(testLines) == 2)
    check(part2(testLines) == 4)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    val lines = input.map { line -> line.split(' ').map(String::toInt) }
    part1(lines).println()
    part2(lines).println()
}
