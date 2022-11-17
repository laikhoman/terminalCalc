package com.model.terminalcalc;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.model.terminalcalc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Calculator mCalculator;

    private String[] TIPE_OPERASI = new String[] {"ADD", "SUBTRACT", "MULTIPLY", "DIVIDE", "SPLITEQ", "SPLITNUM"};
    private String selectedItem = "ADD";
    private Boolean reset = true;

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
                    if (reset) inputText += ("" + addValueText);
                    else inputText += (", " + addValueText);
                    reset = false;
                    binding.contentIcl.inputTf.setText(inputText);
                    binding.contentIcl.inputAddValue.setText("");
                }
            }
        });

        binding.contentIcl.btnEvaluate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer selectedIdx = binding.contentIcl.operationTypeSpinner.getSelectedItemPosition();
                selectedItem = TIPE_OPERASI[selectedIdx];
                if(selectedItem.equals("ADD") ||
                        selectedItem.equals("SUBTRACT") ||
                        selectedItem.equals("MULTIPLY") ||
                        selectedItem.equals("SPLITNUM")
                ) {
                    if(validateInput1()){
                        doCalculate();
                    }
                } else if( selectedItem.equals("DIVIDE") ||
                        selectedItem.equals("SPLITEQ")
                ) {
                    if(validateInput2()){
                        doCalculate();
                    }
                }
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
                    hideSecondLinearLayout();
                } else if (item == "SUBTRACT") {
                    hideSecondLinearLayout();
                } else if (item == "MULTIPLY") {
                    hideSecondLinearLayout();
                } else if (item == "SPLITNUM") {
                    hideSecondLinearLayout();
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
        if(TIPE_OPERASI[selectedIdx].equals("ADD"))
        {
            int output = mCalculator.add(String.valueOf(binding.contentIcl.inputTf.getText()));
            binding.contentIcl.outputTf.setText(String.valueOf(output));
        } else if(TIPE_OPERASI[selectedIdx].equals("SUBTRACT")) {
            int output = mCalculator.subtract(String.valueOf(binding.contentIcl.inputTf.getText()));
            binding.contentIcl.outputTf.setText(String.valueOf(output));
        } else if(TIPE_OPERASI[selectedIdx].equals("MULTIPLY")) {
            int output = mCalculator.multiply(String.valueOf(binding.contentIcl.inputTf.getText()));
            binding.contentIcl.outputTf.setText(String.valueOf(output));
        } else if(TIPE_OPERASI[selectedIdx].equals("SPLITNUM")) {
            int output = mCalculator.splitNum(String.valueOf(binding.contentIcl.inputTf.getText()));
            binding.contentIcl.outputTf.setText(String.valueOf(output));
        } else if(TIPE_OPERASI[selectedIdx].equals("DIVIDE")) {
            int output = mCalculator.divide(
                    Integer.valueOf(String.valueOf(binding.contentIcl.inputFirstValue.getText())),
                    Integer.valueOf(String.valueOf(binding.contentIcl.inputSecondValue.getText()))
            );
            binding.contentIcl.outputTf.setText(String.valueOf(output));
        } else if(TIPE_OPERASI[selectedIdx].equals("SPLITEQ")) {
            String output = mCalculator.splitEq(
                    Integer.valueOf(String.valueOf(binding.contentIcl.inputFirstValue.getText())),
                    Integer.valueOf(String.valueOf(binding.contentIcl.inputSecondValue.getText()))
            );
            binding.contentIcl.outputTf.setText(output);
        }
    }

    private void resetAllField() {
        reset = true;
        binding.contentIcl.inputTf.setText("");
        binding.contentIcl.outputTf.setText("");
        hideSecondLinearLayout();
    }

    private Boolean validateInput1() {
        Boolean valid = false;
        if(!String.valueOf(binding.contentIcl.inputTf.getText()).equals("")){
            valid = true;
        }
        return valid;
    }

    private Boolean validateInput2() {
        Boolean valid = false;
        if(!String.valueOf(binding.contentIcl.inputFirstValue.getText()).equals("")
        && !String.valueOf(binding.contentIcl.inputSecondValue.getText()).equals("")){
            valid = true;
        }
        if(String.valueOf(binding.contentIcl.inputSecondValue.getText()).equals("0")){
            valid = false;
            Toast.makeText(this, "Nilai pembagi tidak boleh nol", Toast.LENGTH_SHORT).show();
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