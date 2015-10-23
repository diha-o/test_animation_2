package pc.dd.test_animation_2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.opengl.Visibility;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParsePosition;

public class animation extends Activity {
    boolean t = true;
    TextView tt;
    TextView tt2;
    ImageView img2;

    LinearLayout ll;
    ListView l;
    ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        im = (ImageView)findViewById(R.id.imageView);
        ll = (LinearLayout) findViewById(R.id.pp);
        tt2 = (TextView) findViewById(R.id.textView3);
        tt2.setVisibility(View.INVISIBLE);
        if(t){
               first_animation(im);
            t=false;}

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animates_bk(v);
            }
        });

        String[] names = {"Дьяченко Дмитрий","Сережка Голгожинский","Мариванна Поляная"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.adapter,names);
         l = (ListView) findViewById(R.id.listView);
        l.setAdapter(adapter);

         tt = (TextView) findViewById(R.id.textView2);
        tt.setVisibility(View.INVISIBLE);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                tt = (TextView) findViewById(R.id.textView2);
                if (position == 0) {
                    tt.setText("Год Рождения:1995\nНомер зачетной книжки:25\nПол:М\nРузультаты последней сесии: Мат:10 Англ.Яз.:10");
                } else if (position == 1) {
                    tt.setText("Год Рождения:1995\nНомер зачетной книжки:28\nПол:М\nРузультаты последней сесии: Мат:8 Англ.Яз.:9");
                } else if (position == 2) {
                    tt.setText("Год Рождения:1994\nНомер зачетной книжки:18\nПол:Ж\nРузультаты последней сесии: Мат:5 Англ.Яз.:5");
                }
                tt.animate()
                        .setDuration(1000)
                        .setInterpolator(new BounceInterpolator())
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationStart(Animator animation) {
                                super.onAnimationStart(animation);
                                tt.setVisibility(View.VISIBLE);

                            }
                        }).start();
            }
        });
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.clearAnimation();
                animation_bek(img2);
            }
        });

        img2 =(ImageView) findViewById(R.id.imageView2);

    }
    public void animation_bek(final View v){
        v.animate()
                .scaleX(0.8F)
                .setDuration(800)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                })
        .start();


        v.animate()
                .scaleY(0.8F)
                .setDuration(800).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                tt.setTextColor(Color.WHITE);
                tt2.setTextColor(Color.WHITE);
                l.setVisibility(View.VISIBLE);
                animation_bek_two();

            }
        })
                .start();

    }
    public void animation_bek_two(){
        img2.animate()
                .translationX(150)
                .translationY(575)
                .setDuration(1000)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        im.clearAnimation();
                        img2.clearAnimation();

                        first_animation(im);
                    }
                })
                .start();
    }
    public void animates_bk(final View v){
        v.animate().
                scaleX(0.8F)
                .scaleY(0.8F)
                .setDuration(800).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                ttw(v);
            }
        })
                .start();




    }
   public void ttw(final View v){
       v.animate().translationXBy(0.5f).translationY(-30).translationXBy(-0.9f).translationX(0).setStartDelay(1000).setDuration(300)
               .setListener(new AnimatorListenerAdapter() {
                   @Override
                   public void onAnimationEnd(Animator animation) {
                       super.onAnimationEnd(animation);
                       animation_move(v);
                   }
               })
               .start();
    }
public void animation_move(View v){

    img2.setVisibility(View.VISIBLE);
    im.setVisibility(View.INVISIBLE);
    img2.setMinimumWidth(30);
    img2.setMaxHeight(30);
      img2.animate()
              .translationX(-150)
              .translationY(-675)
              .setDuration(800)
              .setListener(new AnimatorListenerAdapter() {
                  @Override
                  public void onAnimationEnd(Animator animation) {
                      super.onAnimationEnd(animation);
                      other_anim(img2);
                  }
              })
              .start();
}
    public void other_anim(View v){
        v.animate()
                .scaleX(800)
                .scaleY(800)
                .setDuration(500)
                .start();
        ListView ll = (ListView) findViewById(R.id.listView);
        ll.setVisibility(View.GONE);
        tt.setVisibility(View.VISIBLE);
        tt.setTextColor(Color.DKGRAY);
        tt2.setVisibility(View.VISIBLE);
        tt2.setTextColor(Color.DKGRAY);
        tt.setText("Год Рождения:1994\nНомер зачетной книжки:18\nПол:Ж\nРузультаты последней сесии: Мат:5 Англ.Яз.:5");
    }
public void first_animation(View v) {
    v.setVisibility(View.VISIBLE);
    v.animate().translationXBy(0.5f).translationY(100).translationXBy(-0.9f).translationX(-300).setStartDelay(200).setDuration(300).start();
    LinearLayout pp = (LinearLayout) findViewById(R.id.pp);

    //    pp.setY(pp.getY() - (50) / 2);
   v.animate().scaleX(800).scaleY(800).setStartDelay(1000).setDuration(800);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_animation, menu);
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
}
