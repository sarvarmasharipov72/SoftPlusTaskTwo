package com.sarvarmasharipov72.softplustasktwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.sarvarmasharipov72.softplustasktwo.di.AppComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var appComponent: AppComponent
    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent = (application as MainApp).appComponent
        appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        viewModel.toast.observe(this) {
            if (it.isNotBlank()) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        }
        if (savedInstanceState?.getBoolean(INSTANCE) ?: true) {
            viewModel.getCounter()
        }

    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putBoolean(INSTANCE, false)
    }

    companion object {
        private const val INSTANCE = "instance"
    }
}