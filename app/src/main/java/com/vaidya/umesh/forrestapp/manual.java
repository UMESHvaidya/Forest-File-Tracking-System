package com.vaidya.umesh.forrestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;

public class manual extends AppCompatActivity {
    public PDFView pdfView;
    public float zoomValue=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);

        pdfView=(PDFView)findViewById(R.id.pdfView);
        pdfView.fromAsset("File Tracking System (Manual).pdf").defaultPage(1)
                .spacing(10)
                .load();
    }
    public void nextPage (View view){
        pdfView.jumpTo(pdfView.getCurrentPage()+1,true);
    }
    public void prevPage (View view) {
        pdfView.jumpTo(pdfView.getCurrentPage() - 1, true);
    }
    public void zoomIn(View view){
        ++zoomValue;
        pdfView.zoomTo(zoomValue);
        pdfView.loadPages();
    }
    public void zoomOut(View view){
        if (zoomValue!=1) {
            --zoomValue;
            pdfView.zoomTo(zoomValue);
            pdfView.loadPages();
        }

    }
}
