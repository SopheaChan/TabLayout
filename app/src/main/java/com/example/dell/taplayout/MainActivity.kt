package com.example.dell.taplayout

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(FragmentOne(),"Fragment 1")
        viewPagerAdapter.addFragment(FragmentTwo(),"Fragment 1")
        viewPagerAdapter.addFragment(FragmentThree(),"Fragment 1")

        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater: MenuInflater = getMenuInflater()
            menuInflater.inflate(R.menu.menu, menu)
            return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val menuId: Int = item!!.itemId
        when (menuId){
            R.id.menu_setting->{

            }
            R.id.menu_exit->{
                val builder = AlertDialog.Builder(this)
                    .setTitle("Exit Alert:")
                    .setMessage("Do you want to exit?")
                    .setPositiveButton("Ok"){dialog, which ->
                        finish()
                    }
                val alertDialog: AlertDialog = builder.create()
                alertDialog.show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
