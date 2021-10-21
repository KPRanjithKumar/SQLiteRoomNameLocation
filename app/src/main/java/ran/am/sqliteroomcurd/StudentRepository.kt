package ran.am.sqliteroomcurd




class StudentRepository(private val studentDao: StudentDao) {

    val getStudents: List<Student> = studentDao.getAllUserInfo()

    suspend fun addNote(student: Student){
        studentDao.insertStudent(student)
    }

    suspend fun updateNote(student: Student){
        studentDao.updateStudent(student)
    }

    suspend fun deleteNote(student: Student){
        studentDao.deleteStudent(student)
    }

}