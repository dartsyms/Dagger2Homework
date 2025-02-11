package ru.otus.daggerhomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.otus.daggerhomework.di.DaggerMainActivityComponent
import ru.otus.daggerhomework.di.MainActivityComponent

class MainActivity : AppCompatActivity() {

    lateinit var activityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent = DaggerMainActivityComponent.factory()
            .create(this, (application as App).applicationComponent)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.container, FragmentReceiver())
            .add(R.id.container, FragmentProducer())
            .commit()
    }
}
