package dojo.leeds.problem4

class PupilReader{
    fun readPupilFile(): List<String> {
        return this::class.java.classLoader
                .getResourceAsStream("endOfyearResults.csv")
                .bufferedReader().readLines().drop(1)
    }

    private fun convertToPupil(line: String) : Pupil {
        val elements = line.split(",").map { it.trim() }

        return Pupil(elements[0], elements[1], elements[2],
                elements[3].toInt(), elements[4].toInt(), elements[5].toInt())
    }

    fun fetchPupils() : List<Pupil>{
        return readPupilFile().map { convertToPupil(it) }
    }
}

enum class Grade {
    A, B, C, D, E, F
}

enum class Subject {
    ENGLISH, MATHS, SCIENCE
}

fun Int.toGrade() : Grade = when {
    this >= 80 -> Grade.A
    this >= 70 -> Grade.B
    this >= 60 -> Grade.C
    this >= 50 -> Grade.D
    this >= 45 -> Grade.E
    else -> Grade.F
}

data class Pupil(val name: String, val gender: String, val className: String,
                 val english : Int, val maths: Int, val science: Int){

    val grades : Map<Subject, Grade> = mapOf(Subject.ENGLISH to english.toGrade(),
            Subject.MATHS to maths.toGrade(),
            Subject.SCIENCE to science.toGrade())
    val totalMarks = english + maths + science
}

fun Collection<Pupil>.byClass() = this.groupBy { it.className }  // Separate into Classes
        .entries.sortedBy { it.key }  // Sort Classes by Name


