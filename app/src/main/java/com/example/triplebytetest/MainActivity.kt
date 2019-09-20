package com.example.triplebytetest

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.triplebytetest.adapter.MyAdapter
import com.example.triplebytetest.model.TripleByteTransaction

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MyAdapter(getList())

        }

    }


    fun getList(): List<TripleByteTransaction>{

        var list =  ArrayList<TripleByteTransaction>()

        list.add(TripleByteTransaction("", "", "", true))
        list.add(TripleByteTransaction("Test1", "09/07/15", "$56.99"))
        list.add(TripleByteTransaction("Test2", "09/07/15", "$56.99"))
        list.add(TripleByteTransaction("Test3", "09/07/15", "$56.99"))
        list.add(TripleByteTransaction("Test4", "09/07/15", "$56.99"))


        return list

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
