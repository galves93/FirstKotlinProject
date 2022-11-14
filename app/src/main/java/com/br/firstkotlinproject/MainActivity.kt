package com.br.firstkotlinproject

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor


class MainActivity : AppCompatActivity() {

    lateinit var flutterEngine : FlutterEngine



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flutterEngine = FlutterEngine(this)

        // Start executing Dart code to pre-warm the FlutterEngine.
        flutterEngine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint.createDefault()
        )

        // Cache the FlutterEngine to be used by FlutterActivity.
        FlutterEngineCache
            .getInstance()
            .put("my_engine_id", flutterEngine)
    }


    fun changeTextButton(view: View){
        startActivity(
            FlutterActivity
                .withCachedEngine("my_engine_id")
                .build(this)
        )

        var changeText = findViewById<TextView>(R.id.exibitionText);
        changeText.setText("Botao clicado, texto alterado");
    }
}