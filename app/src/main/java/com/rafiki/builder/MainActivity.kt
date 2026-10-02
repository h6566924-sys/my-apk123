ضع الكود هنا

يمكنك لصق عشرات أو مئات الملفات بنفس الطريقة."/>

            </LinearLayout>


            <!-- ========================= -->
            <!-- أزرار الفحص والإصلاح -->
            <!-- ========================= -->

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="horizontal"
                android:layout_marginBottom="10dp">

                <Button
                    android:id="@+id/analyzeButton"
                    android:layout_width="0dp"
                    android:layout_height="52dp"
                    android:layout_weight="1"
                    android:text="🔍 فحص المشروع"
                    android:textSize="14sp"
                    android:textColor="@color/text"
                    android:backgroundTint="@color/card"
                    android:layout_marginEnd="5dp"/>

                <Button
                    android:id="@+id/fixButton"
                    android:layout_width="0dp"
                    android:layout_height="52dp"
                    android:layout_weight="1"
                    android:text="🛠️ إصلاح"
                    android:textSize="14sp"
                    android:textColor="@color/text"
                    android:backgroundTint="@color/card"
                    android:layout_marginStart="5dp"/>

            </LinearLayout>


            <!-- ========================= -->
            <!-- زر المسح -->
            <!-- ========================= -->

            <Button
                android:id="@+id/clearButton"
                android:layout_width="match_parent"
                android:layout_height="52dp"
                android:text="🗑️ مسح"
                android:textSize="14sp"
                android:textColor="@color/text"
                android:backgroundTint="@color/danger"
                android:layout_marginBottom="10dp"/>


            <!-- ========================= -->
            <!-- الملفات -->
            <!-- ========================= -->

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical"
                android:padding="14dp"
                android:background="@drawable/card_background"
                android:layout_marginBottom="10dp">

                <TextView
                    android:id="@+id/fileCount"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:text="لم يتم اكتشاف ملفات"
                    android:textColor="@color/text"
                    android:textSize="16sp"
                    android:textStyle="bold"
                    android:layout_marginBottom="10dp"/>

                <TextView
                    android:id="@+id/fileList"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:text=""
                    android:textColor="@color/muted"
                    android:textSize="13sp"
                    android:fontFamily="monospace"
                    android:textIsSelectable="true"/>

            </LinearLayout>


            <!-- ========================= -->
            <!-- تقرير الأخطاء -->
            <!-- ========================= -->

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical"
                android:padding="14dp"
                android:background="@drawable/card_background"
                android:layout_marginBottom="10dp">

                <TextView
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:text="⚠️ تقرير الأخطاء"
                    android:textColor="@color/text"
                    android:textSize="17sp"
                    android:textStyle="bold"
                    android:layout_marginBottom="8dp"/>

                <TextView
                    android:id="@+id/errorReport"
                    android:layout_width="match_parent"
                    android:layout_height="180dp"
                    android:background="@drawable/field_background"
                    android:text="بعد الفحص ستظهر الأخطاء هنا."
                    android:textColor="@color/muted"
                    android:textSize="13sp"
                    android:fontFamily="monospace"
                    android:gravity="top|start"
                    android:padding="12dp"
                    android:textIsSelectable="true"
                    android:scrollbars="vertical"/>

                <Button
                    android:id="@+id/copyErrorButton"
                    android:layout_width="match_parent"
                    android:layout_height="50dp"
                    android:text="📋 نسخ تقرير الخطأ"
                    android:textSize="14sp"
                    android:textColor="@color/text"
                    android:backgroundTint="@color/card"
                    android:layout_marginTop="8dp"/>

            </LinearLayout>


            <!-- ========================= -->
            <!-- ZIP -->
            <!-- ========================= -->

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:orientation="vertical"
                android:padding="14dp"
                android:background="@drawable/card_background"
                android:layout_marginBottom="10dp">

                <TextView
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:text="إنشاء المشروع"
                    android:textColor="@color/text"
                    android:textSize="16sp"
                    android:textStyle="bold"
                    android:layout_marginBottom="8dp"/>

                <Button
                    android:id="@+id/zipButton"
                    android:layout_width="match_parent"
                    android:layout_height="54dp"
                    android:text="📦 إنشاء ZIP للمشروع"
                    android:textSize="15sp"
                    android:textStyle="bold"
                    android:textColor="@color/text"
                    android:backgroundTint="@color/blue"/>

                <TextView
                    android:id="@+id/status"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:text="جاهز"
                    android:textColor="@color/muted"
                    android:textSize="14sp"
                    android:paddingTop="12dp"
                    android:textIsSelectable="true"/>

            </LinearLayout>


            <!-- ========================= -->
            <!-- أسفل التطبيق -->
            <!-- ========================= -->

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="Android ZIP Builder — يعمل محليًا على الهاتف"
                android:textColor="@color/muted"
                android:textSize="12sp"
                android:gravity="center"
                android:paddingTop="8dp"
                android:paddingBottom="20dp"/>

        </LinearLayout>

    </ScrollView>

</LinearLayout>