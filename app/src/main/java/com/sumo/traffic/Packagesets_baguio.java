package com.sumo.traffic;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.sumo.traffic.Helpers.HelperView;

/**
 * Created by Amos on 9/25/2017.
 */
public class Packagesets_baguio extends AppCompatActivity implements View.OnClickListener, GestureDetector.OnGestureListener {

    Context mContext = Packagesets_baguio.this;
    private LinearLayout tilesContainer;
    private ScrollView mainScrollView;
    private int[] colors = new int[5];
    private int ANIMATION_DURATION = 300; //in milliseconds
    private int firstChildHeight;
    private int defaultChildHeight;
    private boolean toAnimate = true;
    private boolean toFantasticScroll = true;
    static int packages;
    TextView bottomline;
    private GestureDetectorCompat detector;
    private Toolbar appBar;
    private String[] messages = {
            "Itinerary Sets",
            "Set 1",   //Top Downloads , Top Viewed
            "Set 2",
            "Set 3",
            "Set 4",
            "Set 5"
            // "Send Feedback",
            //  "Contact Us"
    };

    private String[] tagLines = {
            "These are Set of itineraries that contains different variety of destination, You just select any of the Set and you are ready to go.",
            "A new point of View",
            "Even better this year",
            "Get Natural",
            "The Value of Experience",
            "Ultimate in Diversity"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tem_pack);
        appBar = (Toolbar) findViewById(R.id.landingPageAppBar);
        setSupportActionBar(appBar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
        }

        detector = new GestureDetectorCompat(this, this);
        int displayHeight = getWindowManager().getDefaultDisplay().getHeight();
        firstChildHeight = (displayHeight * 60) / 100; //first tile should cover 60% of height
        defaultChildHeight = displayHeight / 6;
        tilesContainer = (LinearLayout) findViewById(R.id.tileContainer);
        mainScrollView = (ScrollView) findViewById(R.id.mainScrollView);
        bottomline = (TextView) findViewById(R.id.textView25);

        mainScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        addTilesToContainer();
        View view = this.getWindow().getDecorView();
        int selectedColor = Color.rgb(255, 240, 214);
        view.setBackgroundColor(selectedColor);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (toFantasticScroll) {
            detector.onTouchEvent(ev);
        }
        return super.dispatchTouchEvent(ev);
    }

    public void addTilesToContainer() {
        View tileView;
        int[] images = {
                R.drawable.img_destmo,
                R.drawable.img_set3,
                R.drawable.img_set4,
                R.drawable.img_set5,
                R.drawable.img_set2,
                R.drawable.img_set1
                //   R.drawable.image_five
        };

        int numberOfTiles = 6;
        for (int i = 0; i < numberOfTiles; i++) {
            if (i == 0) {
                tileView = LayoutInflater.from(mContext).inflate(R.layout.team_or_choi_chanel, null);
                tileView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        firstChildHeight));
                tileView.setTag("tile - " + messages[i]);
                tileView.setOnClickListener(this);

                ImageView imageView = (ImageView) tileView.findViewById(R.id.ivBackground);
                imageView.setImageResource(images[i]);
                tileView.setOnClickListener(this);

                Button button = (Button) tileView.findViewById(R.id.btnTileMessage);
                button.setText(messages[i]);
                button.setTag(i);
                button.setOnClickListener(this);

                TextView tagLine = (TextView) tileView.findViewById(R.id.tvTileTagLine);
                tagLine.setText(tagLines[i]);

                tilesContainer.addView(tileView);
            } else {
                tileView = LayoutInflater.from(mContext).inflate(R.layout.team_or_choi_chanel, null);
                tileView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        defaultChildHeight));
                tileView.setTag("tile - " + messages[i]);
                tileView.setOnClickListener(this);

                ImageView imageView = (ImageView) tileView.findViewById(R.id.ivBackground);
                imageView.setImageResource(images[i]);
                tileView.setOnClickListener(this);

                Button button = (Button) tileView.findViewById(R.id.btnTileMessage);
                button.setText(messages[i]);
                button.setTag(i);
                button.setOnClickListener(this);

                TextView tagLine = (TextView) tileView.findViewById(R.id.tvTileTagLine);
                tagLine.setText(tagLines[i]);
                tagLine.setVisibility(View.INVISIBLE);
                tilesContainer.addView(tileView);
            }
        }

        HelperView.setPrecedingView(null);
        HelperView.setCurrentView(tilesContainer.getChildAt(0));
        HelperView.getCurrentView().findViewById(R.id.tvTileTagLine).setVisibility(View.VISIBLE);
        HelperView.setFollowingView(tilesContainer.getChildAt(1));

    }

    @Override
    public void onClick(final View v) {
        if (v.getTag().toString().contains("tile")) {
            if (v.getLayoutParams().height != firstChildHeight) {
                expandView(v);
            } else {
                switch (tilesContainer.indexOfChild(v)) {
                    case 0:
                        if (tilesContainer.getChildAt(0).getLayoutParams().height != firstChildHeight) {
                            downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
                        } /*else {
                            isFragmentOpened = true;
                         //   fragment = (SampleFragment) Fragment.instantiate(this, SampleFragment.class.getName());
                            addFragmentToScreen(fragment);
                         } */
                        break;

                    case 1:
                        if (tilesContainer.getChildAt(1).getLayoutParams().height != firstChildHeight) {
                            downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
                        } else {
                            Intent intent = new Intent(this, Pack1_baguio.class);
                            startActivity(intent);
                            packages = 1;
                        }

                        break;

                    case 2:
                        if (tilesContainer.getChildAt(2).getLayoutParams().height != firstChildHeight) {
                            downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
                            bottomline.setVisibility(View.VISIBLE);
                        } else {
                            Intent intent = new Intent(this,Pack2_baguio.class);
                            packages = 1;
                            // Intent intent = new Intent(this, ChoicesOfPlace.class);
                            startActivity(intent);
                            // packages = 0;

                        }

                        break;

                    case 3:
                        if (tilesContainer.getChildAt(3).getLayoutParams().height != firstChildHeight) {
                            downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
                        }
                        else {
                            Intent intent = new Intent(this,Pack3_baguio.class);
                            packages = 1;
                            //  Intent intent = new Intent(this, traffic.class);
                            startActivity(intent);
                            //packages = 3;
                        }
                        break;

                    case 4:
                        if (tilesContainer.getChildAt(4).getLayoutParams().height != firstChildHeight) {
                            downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
                        }
                        else {
                            Intent intent = new Intent(this,Pack4_baguio.class);
                            packages = 1;
                            //  Intent intent = new Intent(this, traffic.class);
                            startActivity(intent);
                            //packages = 3;
                        }
                        break;

                    case 5:
                        if (tilesContainer.getChildAt(5).getLayoutParams().height != firstChildHeight) {
                            downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
                        }
                        else {
                            Intent intent = new Intent(this,Pack5_baguio.class);
                            packages = 1;
                            //  Intent intent = new Intent(this, traffic.class);
                            startActivity(intent);
                            //packages = 3;
                        }
                        break;
                    case 6:

                        break;
                }
            }
        }

        switch (v.getTag().toString()) {
            case "0":
                //   Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();
                break;

            case "1":

                if (tilesContainer.getChildAt(1).getLayoutParams().height != firstChildHeight) {
                    downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
                } else {
                    Intent intent = new Intent(this, Pack1_baguio.class);
                    startActivity(intent);
                    packages = 1;
                }
                break;

            case "2":

                if (tilesContainer.getChildAt(2).getLayoutParams().height != firstChildHeight) {
                    downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
                    bottomline.setVisibility(View.VISIBLE);
                } else {
                    Intent intent = new Intent(this, Pack2_baguio.class);
                    startActivity(intent);
                    packages = 1;

                }
                break;

            case "3":
                if (tilesContainer.getChildAt(3).getLayoutParams().height != firstChildHeight) {
                    downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
                    bottomline.setVisibility(View.VISIBLE);
                } else {
                    Intent intent = new Intent(this, Pack3_baguio.class);
                    startActivity(intent);
                    packages = 1;

                }
                break;

            case "4":
                if (tilesContainer.getChildAt(4).getLayoutParams().height != firstChildHeight) {
                    downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
                    bottomline.setVisibility(View.VISIBLE);
                } else {
                    Intent intent = new Intent(this, Pack4_baguio.class);
                    startActivity(intent);
                    packages = 1;

                }
                break;
            case "5":
                if (tilesContainer.getChildAt(5).getLayoutParams().height != firstChildHeight) {
                    downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
                    bottomline.setVisibility(View.VISIBLE);
                } else {
                    Intent intent = new Intent(this, Pack5_baguio.class);
                    startActivity(intent);
                    packages = 1;

                }
                break;
            case "6":
                break;
        }
    }

    public void expandView(final View view) {
        int currentScrollPosition = mainScrollView.getScrollY();
        int finalScrollPosition = view.getTop();

        ValueAnimator scrollAnimator = ValueAnimator.ofInt(currentScrollPosition, finalScrollPosition);
        scrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int amount = (int) animation.getAnimatedValue();
                mainScrollView.scrollTo(0, amount);
            }
        });
        scrollAnimator.setDuration(ANIMATION_DURATION);

        ValueAnimator heightAnimator = ValueAnimator.ofInt(view.getHeight(), firstChildHeight);
        heightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int height = (int) animation.getAnimatedValue();
                view.getLayoutParams().height = height;
                view.requestLayout();
            }
        });
        heightAnimator.setDuration(ANIMATION_DURATION);

        scrollAnimator.start();
        heightAnimator.start();

        if (tilesContainer.indexOfChild(view) == 0) {
            //do nothing
        } else {
            HelperView.setPrecedingView(tilesContainer.getChildAt(tilesContainer.indexOfChild(view) - 1));
        }
        HelperView.setCurrentView(view);
        HelperView.setFollowingView(tilesContainer.getChildAt(tilesContainer.indexOfChild(view) + 1));
        HelperView.getCurrentView().findViewById(R.id.tvTileTagLine).setVisibility(View.VISIBLE);
        if (tilesContainer.indexOfChild(view) < 2) {
            HelperView.getFollowingView().findViewById(R.id.tvTileTagLine).setVisibility(View.INVISIBLE);
        }
    }


    @Override
    public boolean onDown(MotionEvent e) {
        //return true because every gesture start with onDown
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        final int SWIPE_MIN_DISTANCE = 50;
        final int SWIPE_THRESHOLD_VELOCITY = 200;

        if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE &&
                Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
            //Toast.makeText(this, "Bottom to top", Toast.LENGTH_SHORT).show();
            if (HelperView.getFollowingView() != null) {
                downToUpScroll(HelperView.getCurrentView(), HelperView.getFollowingView());
            }
            //From Bottom to top
            return true;
        } else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE &&
                Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
            //Toast.makeText(this, "top to Bottom", Toast.LENGTH_SHORT).show();
            if (HelperView.getPrecedingView() != null) {
                upToDownScroll(HelperView.getPrecedingView(), HelperView.getCurrentView());
            }
            //From top to Bottom
            return true;
        }

        return true;
    }

    public void upToDownScroll(final View precedingView, final View currentView) {

        if (toAnimate) {

            toAnimate = false;

            if (tilesContainer.indexOfChild(currentView) == 0) {
                //do-nothing
            } else {
                int currentScrollPosition = mainScrollView.getScrollY();
                int toScrollPosition = precedingView.getTop();

                ValueAnimator scrollAnimator = ValueAnimator.ofInt(currentScrollPosition, toScrollPosition);
                scrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int amount = (int) animation.getAnimatedValue();
                        mainScrollView.scrollTo(0, amount);
                    }
                });
                scrollAnimator.setDuration(ANIMATION_DURATION);

                ValueAnimator heightAnimator = ValueAnimator.ofInt(currentView.getLayoutParams().height, defaultChildHeight);
                heightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int height = (int) animation.getAnimatedValue();
                        currentView.getLayoutParams().height = height;
                        currentView.requestLayout();
                    }
                });
                heightAnimator.setDuration(ANIMATION_DURATION);

                scrollAnimator.start();
                heightAnimator.start();

                HelperView.setCurrentView(precedingView);
                HelperView.setPrecedingView(tilesContainer.getChildAt(tilesContainer.indexOfChild(precedingView) - 1));
                HelperView.setFollowingView(currentView);
                HelperView.getCurrentView().findViewById(R.id.tvTileTagLine).setVisibility(View.VISIBLE);
                HelperView.getFollowingView().findViewById(R.id.tvTileTagLine).setVisibility(View.INVISIBLE);

                scrollAnimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        toAnimate = false;
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        toAnimate = true;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
            }
        }
    }

    public void downToUpScroll(View currentView, final View followingView) {

        if (toAnimate) {
            toAnimate = false;
            int currentScrollPosition = mainScrollView.getScrollY();
            int toScrollPosition = followingView.getTop();
            ValueAnimator scrollAnimator = ValueAnimator.ofInt(currentScrollPosition, toScrollPosition);
            scrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int amount = (int) animation.getAnimatedValue();
                    mainScrollView.scrollTo(0, amount);
                }
            });
            scrollAnimator.setDuration(ANIMATION_DURATION);

            ValueAnimator heightAnimator = ValueAnimator.ofInt(followingView.getHeight(), firstChildHeight);
            heightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int height = (int) animation.getAnimatedValue();
                    followingView.getLayoutParams().height = height;
                    followingView.requestLayout();
                }
            });
            heightAnimator.setDuration(ANIMATION_DURATION);
            scrollAnimator.start();
            heightAnimator.start();

            scrollAnimator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    toAnimate = true;
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });

            HelperView.setPrecedingView(currentView);
            HelperView.setCurrentView(followingView);
            HelperView.setFollowingView(tilesContainer.getChildAt(tilesContainer.indexOfChild(followingView) + 1));
            HelperView.getCurrentView().findViewById(R.id.tvTileTagLine).setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent i = new Intent(this,TemplateOrChoices.class);
        startActivity(i);
    }

}
