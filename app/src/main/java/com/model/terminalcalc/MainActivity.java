package com.model.terminalcalc;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.model.terminalcalc.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Calculator mCalculator;

    private String[] TIPE_OPERASI = new String[] {"ADD", "SUBTRACT", "MULTIPLY", "DIVIDE", "SPLITEQ", "SPLITNUM"};
    private String selectedItem = "ADD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        mCalculator = new Calculator();
        OperationTypeAdapter operationTypeAdapter = new OperationTypeAdapter(getApplicationContext(), TIPE_OPERASI);
        binding.contentIcl.operationTypeSpinner.setAdapter(operationTypeAdapter);

        binding.contentIcl.btnAddValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = String.valueOf(binding.contentIcl.inputTf.getText());
                if(!binding.contentIcl.inputAddValue.getText().equals("")){
                    String addValueText = String.valueOf(binding.contentIcl.inputAddValue.getText());
                    inputText += (", " + addValueText);
                    binding.contentIcl.inputTf.setText(inputText);
                    binding.contentIcl.inputAddValue.setText("");
                }
            }
        });

        binding.contentIcl.btnEvaluate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateInput()){
                    // operation

                }
//                if(selectedItem.equals("ADD") ||
//                        selectedItem.equals("SUBTRACT") ||
//                        selectedItem.equals("MULTIPLY") ||
//                        selectedItem.equals("SPLITNUM")
//                ) {
//
//                } else if( selectedItem.equals("DIVIDE") ||
//                        selectedItem.equals("SPLITEQ")
//                ) {
//
//                }
            }
        });

        binding.contentIcl.operationTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // TODO Auto-generated method stub
                resetAllField();
                String item = TIPE_OPERASI[position];
                if (item == "ADD") {

                } else if (item == "SUBTRACT") {

                } else if (item == "MULTIPLY") {

                } else if (item == "SPLITNUM") {

                } else if (item == "DIVIDE") {
                    hideFirstLinearLayout();
                } else if (item == "SPLITEQ") {
                    hideFirstLinearLayout();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });


    }

    private void doCalculate() {
        Integer selectedIdx = binding.contentIcl.operationTypeSpinner.getSelectedItemPosition();
        if(TIPE_OPERASI[selectedIdx].equals(""))
        {

        }
    }

    private void resetAllField() {
        binding.contentIcl.inputTf.setText("");
        binding.contentIcl.outputTf.setText("");
        hideSecondLinearLayout();
        binding.contentIcl.operationTypeSpinner.setSelection(0);
    }

    private Boolean validateInput() {
        Boolean valid = false;
        if(!binding.contentIcl.inputTf.equals("")){
            valid = true;
        }
        return valid;
    }

    private void hideFirstLinearLayout() {
        binding.contentIcl.inputAddValue.setText("");
        binding.contentIcl.firstLl.setVisibility(View.GONE);
        binding.contentIcl.secondLl.setVisibility(View.VISIBLE);
    }

    private void hideSecondLinearLayout() {
        binding.contentIcl.inputFirstValue.setText("");
        binding.contentIcl.inputSecondValue.setText("");
        binding.contentIcl.secondLl.setVisibility(View.GONE);
        binding.contentIcl.firstLl.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        super.onSupportNavigateUp();
        return true;
    }
}