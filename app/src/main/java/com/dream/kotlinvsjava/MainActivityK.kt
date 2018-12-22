package com.dream.kotlinvsjava

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.sdk27.coroutines.textChangedListener
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.yesButton
import java.text.SimpleDateFormat
import java.util.*

class MainActivityK : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movie1 = MovieK()

        println("Movie 1 : $movie1")

        val calendar = Calendar.getInstance()
        calendar.set(2012, 3, 25)

        val movie2 = MovieK(2, "Avengers", calendar.time)

        println("Movie 2 : $movie2")

        val movie3 = MovieK(id = 3)

        println("Movie 3 : $movie3")

        val movie4: MovieK = MovieK()
        movie4.id = 4
        movie4.name = "Avengers"
        movie4.releaseDate = calendar.time

        with(movie4) {
            id = 4
            name = "Avengers"
            releaseDate = calendar.time
        }

        movie4.apply {
            id = 4
            name = "Avengers"
            releaseDate = calendar.time
        }

        movie4.run {
            id = 4
            name = "Avengers"
            releaseDate = calendar.time
        }

        movie4.let {
            it.id = 4
            it.name = "Avengers"
            it.releaseDate = calendar.time
        }

        movie4.let { movie ->
            movie.id = 4
            movie.name = "Avengers"
            movie.releaseDate = calendar.time
        }

        val movies = arrayListOf(movie1, movie2, movie3)

        movies.forEach { movie -> println("Movie: $movie") }

        println("sumOfIds : ${movies.sumBy { it.id } }")

        println("getMovieByName: ${getMovieByName(movies, "Avengers")?.name }")

        println("getMovieByName: ${getMovieByName(movies, "Black Panther")?.name }")

        println("getMovieByName: ${getMovieByName(movies, "Black Panther")?.name ?: "Avengers"}")

        // println("getMovieByName: ${getMovieByName(movies, "Black Panther")!!.name }")

        println(movie4.releaseDate.dateToString())

        println(movie4.releaseDate.dateToString().capitalize())

        popup3()
        actionButton3()
        textWatcher2()
    }

    fun getSumOfIds(movies: List<MovieK>) = movies.sumBy { it.id }

    fun getSumOfIds2(movies: List<MovieK>): Int = movies.sumBy { it.id }

    fun getSumOfIds3(movies: List<MovieK>): Int {
        return movies.sumBy { it.id }
    }

    fun getMovieByName(movies: List<MovieK>, name: String): MovieK? =
        movies.firstOrNull { it.name == name }

    fun getMonthName(month: Int) = when(month) {
        1 -> "Janvier"
        2 -> "Février"
        3 -> "Mars"
        4 -> "Avril"
        5 -> "Mai"
        6 -> "Juin"
        7 -> "Juillet"
        8 -> "Aout"
        9 -> "Septembre"
        10 -> "Novembre"
        11 -> "Décembre"
        12 -> "Janvier"
        else -> "Erreur"
    }

    fun Date.dateToString(): String {
        val formatter = SimpleDateFormat("EEEE d MMMM yyyy", Locale.getDefault())
        return "le ${formatter.format(this)}"
    }

    private fun popup() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Supprimer")
        builder.setMessage("Confirmez vous la suppression?")
        builder.setPositiveButton("Oui") { dialog, which ->
            //delete something
        }
        builder.setNegativeButton("Non") { _, _ -> }
        val dialog = builder.create()
        dialog.show()
    }

    private fun popup2() {
        val dialog = AlertDialog.Builder(this).apply {
            setTitle("Supprimer")
            setMessage("Confirmez vous la suppression?")
            setPositiveButton("Oui") { dialog, which -> /*delete something */ }
            setNegativeButton("Non") { _, _ -> }
        }.create()
        dialog.show()
    }

    private fun popup3() {
        alert(title = "Supprimer", message = "Confirmez vous la suppression?") {
            yesButton { /*delete something */ }
            noButton { }
        }.show()
    }

    private fun actionButton() {
        val actionButton = findViewById<Button>(R.id.actionButton)
        actionButton.setOnClickListener { launchNextActivity() }
    }

    private fun actionButton2() {
        actionButton.setOnClickListener { launchNextActivity() }
    }

    private fun actionButton3() {
        actionButton.onClick { launchNextActivity2() }
    }

    private fun launchNextActivity() {
        val intent = Intent(this@MainActivityK, ActivityDetail::class.java)
        intent.putExtra("id", 1)
        startActivity(intent)
    }

    private fun launchNextActivity2() {
        startActivity<ActivityDetail>("id" to 1, "id2" to 2)
    }

    var name = ""

    private fun textWatcher() {
        nameEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(charSequence: CharSequence, start: Int, before: Int, count: Int) {
                name = charSequence.trim().toString().capitalize()
            }

            override fun afterTextChanged(s: Editable) { }
        })
    }

    private fun textWatcher2() {
        nameEditText.textChangedListener {
            onTextChanged { charSequence, _, _, _ ->
                name = charSequence?.trim().toString().capitalize()
            }
        }
    }
}
