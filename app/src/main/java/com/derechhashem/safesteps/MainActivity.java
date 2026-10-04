package com.derechhashem.safesteps;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.graphics.Color;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity {
    private final Handler handler = new Handler();
    private long blockedUntil;
    @Override public void onCreate(Bundle b) { super.onCreate(b); showHome(); }
    private TextView text(String s, float size) { TextView t=new TextView(this); t.setText(s); t.setTextSize(size); t.setTextColor(Color.rgb(23,50,77)); t.setGravity(Gravity.CENTER); t.setPadding(24,18,24,18); return t; }
    private void showHome() {
        LinearLayout l=new LinearLayout(this); l.setOrientation(LinearLayout.VERTICAL); l.setGravity(Gravity.CENTER); l.setPadding(28,28,28,28); l.setBackgroundColor(Color.rgb(244,248,252));
        TextView title=text("דרך השם",34); title.setTextColor(Color.rgb(16,42,67));
        l.addView(title); l.addView(text("מערכת סינון והגנה",20)); l.addView(text("המכשיר מוגן",18));
        Button b=new Button(this); b.setText("בדיקת פעולה חסומה"); b.setOnClickListener(v->showBlockedPage()); l.addView(b);
        setContentView(l);
    }
    private void showBlockedPage() {
        blockedUntil=System.currentTimeMillis()+2000;
        LinearLayout l=new LinearLayout(this); l.setOrientation(LinearLayout.VERTICAL); l.setGravity(Gravity.CENTER); l.setPadding(24,24,24,24); l.setBackgroundColor(Color.rgb(244,248,252));
        TextView title=text("הפעולה חסומה",30); title.setTextColor(Color.rgb(25,118,210));
        l.addView(title); l.addView(text("המכשיר מוגן על ידי מערכת סינון דרך השם.\n\nהגישה למסך זה נחסמה כדי לשמור על הגנת המכשיר.",19));
        Button back=new Button(this); back.setText("חזור"); back.setEnabled(false); back.setAlpha(.45f); l.addView(back);
        l.setOnTouchListener((v,e)->System.currentTimeMillis()<blockedUntil);
        back.setOnClickListener(v->showHome()); setContentView(l);
        handler.postDelayed(()->{back.setEnabled(true); back.setAlpha(1f);},2000);
    }
    @Override public void onBackPressed() { if(System.currentTimeMillis()<blockedUntil) return; showHome(); }
}
