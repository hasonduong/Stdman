package vn.edu.hust.studentman

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(
  private val students: List<StudentModel>,
  private val onEditClick: (StudentModel, Int) -> Unit,
  private val onDeleteClick: (StudentModel, Int) -> Unit
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

  inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textStudentName: TextView = itemView.findViewById(R.id.text_student_name)
    private val textStudentId: TextView = itemView.findViewById(R.id.text_student_id)
    private val imageEdit: ImageView = itemView.findViewById(R.id.image_edit)
    private val imageRemove: ImageView = itemView.findViewById(R.id.image_remove)

    fun bind(student: StudentModel, position: Int) {
      textStudentName.text = student.studentName
      textStudentId.text = student.studentId

      // Sự kiện khi nhấn vào biểu tượng chỉnh sửa
      imageEdit.setOnClickListener { onEditClick(student, position) }

      // Gửi sự kiện khi nhấn vào biểu tượng xóa
      imageRemove.setOnClickListener { onDeleteClick(student, position) }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
    val itemView = LayoutInflater.from(parent.context)
      .inflate(R.layout.layout_student_item, parent, false)
    return StudentViewHolder(itemView)
  }

  override fun getItemCount(): Int = students.size

  override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
    holder.bind(students[position], position)
  }
}
