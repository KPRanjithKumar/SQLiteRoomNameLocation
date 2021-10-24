package ran.am.sqliteroomcurd

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudentDao {

    @Query("SELECT * FROM Student where Name=:name ORDER BY Name DESC")
    fun getAllUserInfo(name: String): List<Student>

    @Insert
    fun insertStudent(student: Student)


}