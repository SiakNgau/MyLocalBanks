package sg.edu.rp.c346.id22027706.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    String bankClicked = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        String website = "Website";

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
        menu.add(0,2,2,"Toggle Favourite");

        if (v == tvDBS) {
            bankClicked = "DBS";
        }
        else if(v == tvOCBC) {
            bankClicked = "OCBC";
        }
        else if(v == tvUOB) {
            bankClicked = "UOB";
        }
    }

    boolean fav = true;
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (bankClicked.equalsIgnoreCase("DBS")) {
            if(item.getItemId()==0) {
                Intent intentURL = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentURL);
                return true;
            }
            else if(item.getItemId()==1) {
                String dbsHotline = "18001111111";
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + dbsHotline));
                startActivity(intentCall);
                return true;

            }
            else if(item.getItemId()==2) {
                if (fav == true) {
                    tvDBS.setTextColor(Color.parseColor("#FF0000"));
                    fav = false;
                } else {
                    tvDBS.setTextColor(Color.parseColor("#000000"));
                    fav = true;
                }
            }

        }else if (bankClicked.equalsIgnoreCase("OCBC")){
                if(item.getItemId()==0) {
                    Intent intentURL = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                    startActivity(intentURL);
                    return true;
            }
            else if(item.getItemId()==1) {
                    String ocbcHotline = "18003633333";
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + ocbcHotline));
                    startActivity(intentCall);
                    return true;
            }
            else if(item.getItemId()==2) {
                if (fav == true) {
                    tvOCBC.setTextColor(Color.parseColor("#FF0000"));
                    fav = false;
                } else {
                    tvOCBC.setTextColor(Color.parseColor("#000000"));
                    fav = true;
                }
            }

        } else {
            if(item.getItemId()==0) {
                Intent intentURL = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentURL);
                return true;
            }
            else if(item.getItemId()==1) {
                String uobHotline = "18002222121";
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + uobHotline));
                startActivity(intentCall);
                return true;
            }
            else if(item.getItemId()==2) {
                if (fav == true) {
                    tvUOB.setTextColor(Color.parseColor("#FF0000"));
                    fav = false;
                } else {
                    tvUOB.setTextColor(Color.parseColor("#000000"));
                    fav = true;
                }
            }}
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.chineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        } else {
            tvDBS.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }
}