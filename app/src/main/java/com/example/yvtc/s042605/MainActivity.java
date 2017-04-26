package com.example.yvtc.s042605;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {
    String outFilename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        outFilename = getFilesDir().getAbsolutePath() + File.separator + "phone.sqlite";
        try {
            copyDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void copyDatabase() throws IOException {
        // Path to the empty database.


        // Open the empty database as the output stream.
        OutputStream outputDatabase = new FileOutputStream(outFilename);
        // Transfer bytes from the input file to the output file.
        byte[] buffer = new byte[1024];
        InputStream is = getResources().openRawResource(R.raw.phone_danniel);
        int length;
        while ((length = is.read(buffer)) > 0) {
            outputDatabase.write(buffer, 0, length);
        }
        is.close();
        outputDatabase.flush();
        outputDatabase.close();
    }
}
