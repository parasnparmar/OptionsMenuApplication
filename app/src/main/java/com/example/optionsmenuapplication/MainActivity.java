package com.example.optionsmenuapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int MENU_PHONE_SETTINGS = 1, MENU_DISPLAY_SETTINGS = 2, MENU_BLUETOOTH_SETTINGS = 3, MENU_HELP = 4, MENU_HISTORY = 5, MENU_EXIT=6;
    CheckBox enableSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        enableSettings = findViewById(R.id.enableSettings);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Toast.makeText(this,"onCreateOptionMenu Called",Toast.LENGTH_SHORT).show();
        SubMenu menu1;
        menu1 = menu.addSubMenu(1, 1, MENU_PHONE_SETTINGS, "Phone Settings");
        menu1.addSubMenu(1, 2, MENU_DISPLAY_SETTINGS, "Display Settings");
        menu1.addSubMenu(1, 3, MENU_BLUETOOTH_SETTINGS, "Bluetooth Settings");
        
        MenuItem helpMenuItem = menu1.add(1, 4, MENU_HELP, "Help");
        MenuItem historyMenuItem = menu1.add(1, 5, MENU_HISTORY, "History");
        MenuItem exit = menu.add(1,6,MENU_EXIT,"Exit");


        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Toast.makeText(this,"onPrepareOptionMenu Called",Toast.LENGTH_SHORT).show();
        menu.setGroupVisible(1,true);
        menu.setGroupEnabled(1,(enableSettings.isChecked()));
        menu.findItem(4);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this,"onOptionsItemSelected Called",Toast.LENGTH_SHORT).show();

        int itemId = item.getItemId();
        switch (itemId) {
            case 1:
                Log.d("Tag", "Phone Setting Selected");
                break;
            case 2:
                Toast.makeText(this,"Display Settings Selected",Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
                break;
            case 4:
                Toast.makeText(this,"Help CLicked!",Toast.LENGTH_SHORT).show();
                break;
            case 5:
                Toast.makeText(this,"History Clicked!!",Toast.LENGTH_SHORT).show();
                break;
            case 6:
                Toast.makeText(this,"Exit",Toast.LENGTH_SHORT).show();
                break;

        }
            return true;
    }
}