package br.com.fbrandao.util;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.fbrandao.R;

import br.com.fbrandao.activity.MenuActivity;

/**
 * Created by thiago_henrique on 23/03/2017.
 */

public class Util {

    private int[] viewsHomePage = {R.id.texto_home_view_02,
                                   R.id.texto_home_view_03,
                                   R.id.texto_home_view_04,
                                   R.id.texto_home_view_05,
                                   R.id.texto_home_view_06_part_one,
                                   R.id.texto_home_view_06_part_two,
                                   R.id.texto_home_view_06_part_three,
                                   R.id.texto_home_view_07,
                                   R.id.texto_home_view_08,
                                   R.id.texto_home_view_09,
                                   R.id.texto_home_view_10,
                                   R.id.texto_home_view_11_part_one,
                                   R.id.texto_home_view_11_part_two};

    private int[] textsHomePage = {R.string.texto_home_view_02,
                                   R.string.texto_home_view_03,
                                   R.string.texto_home_view_04,
                                   R.string.texto_home_view_05,
                                   R.string.texto_home_view_06_part_one,
                                   R.string.texto_home_view_06_part_two,
                                   R.string.texto_home_view_06_part_three,
                                   R.string.texto_home_view_07,
                                   R.string.texto_home_view_08,
                                   R.string.texto_home_view_09,
                                   R.string.texto_home_view_10,
                                   R.string.texto_home_view_11_part_one,
                                   R.string.texto_home_view_11_part_two};

    public void loadViewFlipperHome(MenuActivity menuActivity){
        for (int i = 0; i < viewsHomePage.length; i++) {

            //justify text
            String html = "<body style=\"text-align:justify;color:white;\"> %s </body>";

            //text color black for backgrounds white
            if(i == 1 | i == 3 | i == 7 | i == 8 | i == 12 | i == 11){
                //justify text
                html = "<body style=\"text-align:justify;color:gray;\"> %s </body>";
            }

            //get text
            String textView = menuActivity.getString(textsHomePage[i]);
            //get view
            WebView webView = (WebView) menuActivity.findViewById(viewsHomePage[i]);
            //set text in view
            webView.loadData(String.format(html, textView), "text/html; charset=utf-8", "UTF-8");
            //set background color
            webView.setBackgroundColor(Color.TRANSPARENT);
        }
    }
}
