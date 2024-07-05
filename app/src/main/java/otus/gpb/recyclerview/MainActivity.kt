package otus.gpb.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ChatAdapter()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.adapter = adapter

        adapter.setItems(generateList())

    }

    fun generateList() = run {
        val list = mutableListOf<Chat>()
        repeat(50){
            val person = Chat(
                id = it,
                name = "Name + $it",
                title = "Name title $it",
                message = "This is message",
                time = "12:12 AM",
                image = R.drawable.default_avatar
            )
            list.add(person)
        }
        list.toList()
    }
}