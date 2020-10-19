package com.example.event_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
//Minimum number of Platforms required or stalls required for party

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText e1,e2,e3;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.b1);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);


         b1.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View view) {
                    int size=Integer.parseInt(e1.getText().toString());
                 String [] temp1=e2.getText().toString().split(",");
                 int arr1[]=new int[size];
                 for(int i=0;i<size;i++){
                     arr1[i]=Integer.parseInt(temp1[i]);

                 }
                 String [] temp2=e3.getText().toString().split(",");
                 int arr2[]=new int[size];
                 for(int i=0;i<size;i++){
                     arr2[i]=Integer.parseInt(temp2[i]);

                 }

                 int result=calculateMin(arr1,arr2);
                 Intent intent=new Intent(getApplicationContext(),Result.class);
                 intent.putExtra("key",Integer.toString(result));
                 startActivity(intent);
             }
             public int calculateMin(int arr[],int dep[]){
                 int n=arr.length;
                 Arrays.sort(arr);
                 Arrays.sort(dep);

                 // plat_needed indicates number of platforms
                 // needed at a time
                 int plat_needed = 1, result = 1;
                 int i = 1, j = 0;

                 // Similar to merge in merge sort to process
                 // all events in sorted order
                 while (i < n && j < n) {
                     // If next event in sorted order is arrival,
                     // increment count of platforms needed
                     if (arr[i] <= dep[j]) {
                         plat_needed++;
                         i++;
                     }

                     // Else decrement count of platforms needed
                     else if (arr[i] > dep[j]) {
                         plat_needed--;
                         j++;
                     }

                     // Update result if needed
                     if (plat_needed > result)
                         result = plat_needed;
                 }

                 return result;
             }



         });
    }
}