package ran.am.sqliteroomcurd

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

import androidx.room.*

@Dao
interface StudentDao {

    @Query("SELECT * FROM Student ORDER BY Name DESC")
    fun getAllUserInfo(): List<Student>


    @Insert
    fun insertStudent(student: Student)

    @Delete
    fun deleteStudent(student: Student)

    @Update
    fun updateStudent(student: Student)

}