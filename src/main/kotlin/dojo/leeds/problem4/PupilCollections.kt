package dojo.leeds.problem4

class PupilReader{
    fun readPupilFile(): List<String> {
        return this::class.java.classLoader
                .getResourceAsStream("endOfyearResults.csv")
                .bufferedReader().readLines()
    }
}