package com.example.a411_list_view_den;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = findViewById(R.id.listView);

        List<Map<String, String>> content = prepareContent();

        SimpleAdapter listContentAdapter = createAdapter(content);

        list.setAdapter(listContentAdapter);


    }


    @NonNull
    private SimpleAdapter createAdapter(List<Map<String, String>> content) {
        return new SimpleAdapter(this, content, R.layout.listlayout, new String[]{"text","length"}, new int[]{R.id.textView, R.id.textView2});
    }

    @NonNull
    private List<Map<String, String>> prepareContent() {
        List<Map<String, String>> contentList = new ArrayList<>();
        String[] arrayContent = getString(R.string.large_text).split("\n\n");
        Map<String, String> mapForList;
        for (int i = 0 ; i < arrayContent.length ; i++){
            mapForList = new HashMap<>();
            mapForList.put("text",arrayContent[i]);
            mapForList.put("length",Integer.toString(arrayContent[i].length()));
            contentList.add(mapForList);
        };
        return contentList;
    }

}
