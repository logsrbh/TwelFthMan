package test.labs.twelfthman;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import test.labs.twelfthman.Fragments.ChatFragment;
import test.labs.twelfthman.Fragments.HomeFragment;
import test.labs.twelfthman.Fragments.ScoreFragment;
import test.labs.twelfthman.Fragments.TableFragment;


public class HomeActivity extends AppCompatActivity {
    private static final String TITLE = "title";
    private static final String imageURL = "imageURL";
    static String one, two, three, four;
    HashMap<String, String> HashMapForURL;
    HashMap<String, Integer> HashMapForLocalRes;
    TableFragment tableFragment;
    ChatFragment chatFragment;
    ScoreFragment scoreFragment;
    HomeFragment homeFragment;
    private RecyclerView newsRecycler;
    private AccountHeader headerResult;
    private Drawer result;
    private FirebaseFirestore db;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<NewsModel> newsList;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);
        db = FirebaseFirestore.getInstance();
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");*/

        /*final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitleEnabled(false);*/

        /*newsRecycler = findViewById(R.id.newsRecycler);
        AppBarLayout appbar = findViewById(R.id.appbar);
        appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbarLayout.setTitle(" ");//carefull there should a space between double quote otherwise it wont work
                    isShow = false;
                }
            }
        });*/
        /*headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withCompactStyle(false)
                .withHeaderBackground(R.drawable.ic_person_black_24dp)
                .withSavedInstance(savedInstanceState)
                .build();*/


        result = new DrawerBuilder()
                .withActivity(this)
                // .withToolbar(toolbar)
                .withSliderBackgroundColor(getResources().getColor(android.R.color.black))


                .withFullscreen(false)
                .addDrawerItems(
                        new PrimaryDrawerItem().withTextColorRes(R.color.md_white_1000).withName("FOOTBALL").withIcon(new IconicsDrawable(this).icon(FontAwesome.Icon.faw_futbol)
                                .color(Color.RED)
                                .sizeDp(24)).withSubItems(
                                new SecondaryDrawerItem().withName("\t\tENGLISH PREMIER LEAGUE").withTextColorRes(R.color.md_white_1000),
                                new SecondaryDrawerItem().withName("\t\tLA LIGA").withTextColorRes(R.color.md_white_1000),
                                new SecondaryDrawerItem().withName("\t\tBUNDESLIGA").withTextColorRes(R.color.md_white_1000),
                                new SecondaryDrawerItem().withName("\t\tSERIE A").withTextColorRes(R.color.md_white_1000),
                                new SecondaryDrawerItem().withName("\t\tLEAGUE 1").withTextColorRes(R.color.md_white_1000),
                                new SecondaryDrawerItem().withName("\t\tMLS").withTextColorRes(R.color.md_white_1000),
                                new SecondaryDrawerItem().withName("\t\tUEFA").withTextColorRes(R.color.md_white_1000),
                                new SecondaryDrawerItem().withName("\t\tINDIAN SUPER LEAGUE").withTextColorRes(R.color.md_white_1000)
                        ).withIdentifier(1),
                        new PrimaryDrawerItem().withTextColorRes(R.color.md_white_1000).withName("CRICKET").withIcon(getDrawable(R.drawable.ic_cricket)).
                                withSubItems(new SecondaryDrawerItem().withName("\t\tIPL").withTextColorRes(R.color.md_white_1000)
                                ),
                        new PrimaryDrawerItem().withTextColorRes(R.color.md_white_1000).withName("WWE").withIcon(getDrawable(R.drawable.wwe)),
                        // new SectionDrawerItem().withName(R.string.drawer_item_section_header))
                        new PrimaryDrawerItem().withName("JOIN US").withTextColorRes(R.color.md_white_1000).withIcon(new IconicsDrawable(this).icon(FontAwesome.Icon.faw_user_plus).color(Color.RED).sizeDp(24)))
                .withSavedInstance(savedInstanceState)
                .build();


        setupBottomNav();
        tableFragment = new TableFragment();
        chatFragment = new ChatFragment();
        scoreFragment = new ScoreFragment();
        homeFragment = new HomeFragment();
        newsList = new ArrayList<>();

        initializeFragment();
       /* linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);*/
        //dividerItemDecoration = new DividerItemDecoration(newsRecycler.getContext(), linearLayoutManager.getOrientation());

        /*newsRecycler.setHasFixedSize(true);
        newsRecycler.setLayoutManager(linearLayoutManager);*/
        //newsRecycler.addItemDecoration(dividerItemDecoration);
        // newsRecycler.setAdapter(adapter);

        //  loadNews();
        // loadSlider();
    }

    private void initializeFragment() {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.add(R.id.containerFrame, chatFragment);
        fragmentTransaction.add(R.id.containerFrame, tableFragment);
        fragmentTransaction.add(R.id.containerFrame, scoreFragment);
        fragmentTransaction.add(R.id.containerFrame, homeFragment);

        fragmentTransaction.hide(chatFragment);
        fragmentTransaction.hide(tableFragment);
        fragmentTransaction.hide(scoreFragment);

        fragmentTransaction.commit();

    }

    private void setupBottomNav() {


        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);

// Create items
        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.tab_1, R.drawable.ic_folded_newspaper, R.color.color_tab_1);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.tab_2, R.drawable.ic_table, R.color.color_tab_2);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tab_3, R.drawable.ic_scoreboard, R.color.color_tab_3);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.tab_4, R.drawable.ic_chat, R.color.color_tab_3);

// Add items
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        bottomNavigation.addItem(item4);

// Set background color
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

// Disable the translation inside the CoordinatorLayout
        bottomNavigation.setBehaviorTranslationEnabled(false);

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.containerFrame);

                if (position == 0)

                    replaceFragment(homeFragment, currentFragment);

                else if (position == 1)

                    replaceFragment(tableFragment, currentFragment);
                else if (position == 2)

                    replaceFragment(scoreFragment, currentFragment);
                else if (position==3)

                    replaceFragment(chatFragment,currentFragment);


                return true;
            }
        });
    }


    private void replaceFragment(Fragment fragment, Fragment currentFragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (fragment == homeFragment) {

            fragmentTransaction.hide(chatFragment);
            fragmentTransaction.hide(scoreFragment);
            fragmentTransaction.hide(tableFragment);

        }

        if (fragment == chatFragment) {

            fragmentTransaction.hide(homeFragment);
            fragmentTransaction.hide(scoreFragment);
            fragmentTransaction.hide(tableFragment);

        }

        if (fragment == scoreFragment) {

            fragmentTransaction.hide(homeFragment);
            fragmentTransaction.hide(chatFragment);
            fragmentTransaction.hide(tableFragment);

        }
        if (fragment == tableFragment) {

            fragmentTransaction.hide(homeFragment);
            fragmentTransaction.hide(chatFragment);
            fragmentTransaction.hide(scoreFragment);

        }
        fragmentTransaction.show(fragment);

        //fragmentTransaction.replace(R.id.main_container, fragment);
        fragmentTransaction.commit();

    }




    @Override
    protected void onStop() {
        super.onStop();
    }

}
