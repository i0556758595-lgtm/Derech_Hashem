# דרך השם

פרויקט Android בסיסי למערכת סינון והגנה.

## בניית APK אוטומטית ב-GitHub

הקובץ `.github/workflows/build-apk.yml` מפעיל GitHub Actions בכל Push ל-main/master, וגם מאפשר הפעלה ידנית.

בסיום הבנייה ה-APK זמין תחת **Actions → workflow run → Artifacts → Derech-Hashem-debug-apk**.

> הערה: חסימה אמיתית של Safe Mode, הגדרות Wi‑Fi/Google, איפוס המכשיר ומסכי מערכת דורשת ניהול מכשיר מתאים, כגון Device Owner / Android Enterprise, בהתאם למכשיר ולגרסת Android. הפרויקט הזה אינו מציג זאת כאילו אפליקציה רגילה יכולה לעקוף את מערכת Android.
