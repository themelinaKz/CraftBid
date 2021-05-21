package com.craftbid.craftbid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EditListingActivity extends CreateListingActivity implements View.OnClickListener {
    private int listing_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle b = getIntent().getExtras();
        if(b!=null){
            listing_id = b.getInt("listing_id");
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.edit);

        TextView title = findViewById(R.id.listing_name);
        title.setText(R.string.edit);

        TextView note = findViewById(R.id.note);
        note.setVisibility(View.VISIBLE);

        //Listing time is not editable
        findViewById(R.id.title_edit).setVisibility(View.GONE);
        findViewById(R.id.title_noedit).setVisibility(View.VISIBLE);

        findViewById(R.id.save_btn).setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                goBack();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void goBack() {
        Log.d("EDIT", "openListing: OPENED");
        Intent listing = new Intent(EditListingActivity.this, ListingPrivateActivity.class);
        listing.putExtra("listing_id", listing_id);
        startActivity(listing);
    }

    @Override
    public void onClick(View v) {
        // TODO save edited listing
        goBack();
    }
}