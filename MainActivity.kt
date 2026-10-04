<!DOCTYPE html>
<html lang="ar" dir="rtl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>محول المشاريع الذكي إلى APK - النسخة النهائية</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js"></script>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh; padding: 20px; direction: rtl;
        }
        .container {
            max-width: 950px; margin: 0 auto; background: white;
            border-radius: 20px; box-shadow: 0 20px 60px rgba(0,0,0,0.3); overflow: hidden;
        }
        .header {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white; padding: 30px; text-align: center;
        }
        .header h1 { font-size: 26px; margin-bottom: 10px; }
        .header p { font-size: 14px; opacity: 0.9; }
        .content { padding: 30px; }
        .section {
            margin-bottom: 25px; padding: 20px;
            border: 2px solid #e0e0e0; border-radius: 15px;
        }
        .section-title {
            font-size: 18px; color: #333; margin-bottom: 15px;
            display: flex; align-items: center; gap: 10px; font-weight: bold;
        }
        .btn {
            padding: 12px 20px; border: none; border-radius: 8px;
            font-size: 14px; font-weight: 600; cursor: pointer;
            transition: all 0.3s; display: inline-flex;
            align-items: center; gap: 8px; margin: 5px;
        }
        .btn:disabled { opacity: 0.6; cursor: not-allowed; }
        .btn-primary { background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); color: white; }
        .btn-primary:hover:not(:disabled) { transform: translateY(-2px); box-shadow: 0 5px 15px rgba(102, 126, 234, 0.4); }
        .btn-secondary { background: #f0f0f0; color: #333; }
        .btn-secondary:hover:not(:disabled) { background: #e0e0e0; }
        .btn-success { background: linear-gradient(135deg, #11998e 0%, #38ef7d 100%); color: white; }
        .btn-success:hover:not(:disabled) { transform: translateY(-2px); box-shadow: 0 5px 15px rgba(56, 239, 125, 0.4); }
        .btn-danger { background: #ff4757; color: white; }
        .btn-danger:hover:not(:disabled) { background: #ff3838; }
        .btn-back { background: #ffa502; color: white; font-size: 16px; padding: 14px 28px; }
        .btn-back:hover:not(:disabled) { background: #e69500; }
        .input-group { margin-bottom: 15px; }
        .input-group label { display: block; margin-bottom: 8px; color: #333; font-weight: 600; }
        .input-group input, .input-group textarea, .input-group select {
            width: 100%; padding: 12px; border: 2px solid #e0e0e0; border-radius: 8px; font-size: 14px;
        }
        .input-group input:focus, .input-group textarea:focus { outline: none; border-color: #667eea; }
        .file-upload {
            border: 3px dashed #e0e0e0; border-radius: 15px; padding: 40px;
            text-align: center; cursor: pointer; transition: all 0.3s;
        }
        .file-upload:hover { border-color: #667eea; background: #f8f9ff; }
        .file-upload.dragover { border-color: #667eea; background: #f0f4ff; }
        .status-message {
            padding: 15px; border-radius: 10px; margin-top: 15px;
            display: none; font-size: 14px; line-height: 1.6;
        }
        .status-message.success { background: #d4edda; color: #155724; border: 1px solid #c3e6cb; display: block; }
        .status-message.error { background: #f8d7da; color: #721c24; border: 1px solid #f5c6cb; display: block; }
        .status-message.info { background: #d1ecf1; color: #0c5460; border: 1px solid #bee5eb; display: block; }
        .project-info {
            background: #f8f9fa; border-radius: 10px; padding: 15px; margin-top: 15px; display: none;
        }
        .project-info.show { display: block; }
        .info-item { display: flex; justify-content: space-between; padding: 8px 0; border-bottom: 1px solid #e0e0e0; }
        .info-item:last-child { border-bottom: none; }
        .info-label { font-weight: 600; color: #666; }
        .info-value { color: #333; font-weight: bold; }
        .progress-bar {
            width: 100%; height: 8px; background: #e0e0e0;
            border-radius: 10px; overflow: hidden; margin-top: 15px; display: none;
        }
        .progress-fill {
            height: 100%; background: linear-gradient(90deg, #667eea 0%, #764ba2 100%);
            width: 0%; transition: width 0.3s;
        }
        .download-links { margin-top: 20px; padding: 20px; background: #f8f9fa; border-radius: 10px; display: none; }
        .download-links.show { display: block; }
        .download-link {
            display: block; padding: 15px; background: white; border: 2px solid #e0e0e0;
            border-radius: 8px; margin-bottom: 10px; text-decoration: none; color: #333;
            transition: all 0.3s; word-break: break-all; font-weight: bold;
        }
        .download-link:hover { border-color: #667eea; transform: translateX(-5px); }
        .download-link.direct { background: #d4edda; border-color: #28a745; color: #155724; }
        .file-list { margin-top: 15px; max-height: 250px; overflow-y: auto; }
        .file-item {
            display: flex; justify-content: space-between; align-items: center;
            padding: 10px; background: #f8f9fa; border-radius: 8px; margin-bottom: 8px;
        }
        .file-item .file-name { flex: 1; font-size: 13px; word-break: break-all; }
        .file-item .file-size { color: #666; font-size: 12px; margin: 0 10px; }
        .tabs { display: flex; gap: 10px; margin-bottom: 20px; flex-wrap: wrap; }
        .tab {
            padding: 10px 20px; background: #f0f0f0; border-radius: 8px;
            cursor: pointer; transition: all 0.3s;
        }
        .tab.active { background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); color: white; }
        .tab-content { display: none; }
        .tab-content.active { display: block; }
        .repo-list { max-height: 250px; overflow-y: auto; margin-top: 15px; }
        .repo-item {
            padding: 12px; background: #f8f9fa; border-radius: 8px; margin-bottom: 8px;
            cursor: pointer; transition: all 0.3s;
        }
        .repo-item:hover { background: #e9ecef; transform: translateX(-5px); }
        .repo-item.selected { background: #667eea; color: white; }
        .warning-box {
            background: #fff3cd; color: #856404; border: 1px solid #ffeaa7;
            padding: 15px; border-radius: 8px; margin-bottom: 15px; font-size: 13px;
        }
        .history-item {
            padding: 15px; background: #f8f9fa; border-radius: 8px;
            margin-bottom: 10px; border-right: 4px solid #667eea;
        }
        .history-item.success { border-right-color: #28a745; }
        .history-item.failed { border-right-color: #dc3545; }
        .history-item.pending { border-right-color: #ffc107; }
        .history-header { display: flex; justify-content: space-between; align-items: center; margin-bottom: 8px; }
        .history-title { font-weight: bold; color: #333; }
        .history-date { font-size: 12px; color: #666; }
        .history-actions { display: flex; gap: 8px; margin-top: 10px; flex-wrap: wrap; }
        .history-btn {
            padding: 6px 12px; border: none; border-radius: 6px;
            font-size: 12px; cursor: pointer; text-decoration: none;
            display: inline-block; color: white;
        }
        .history-btn.download { background: #28a745; }
        .history-btn.view { background: #17a2b8; }
        .history-btn.delete { background: #dc3545; }
        @keyframes spin { 0% { transform: rotate(0deg); } 100% { transform: rotate(360deg); } }
        .spinner {
            display: inline-block; width: 18px; height: 18px; border: 3px solid #f3f3f3;
            border-top: 3px solid #667eea; border-radius: 50%; animation: spin 1s linear infinite;
        }
        textarea.code-input {
            width: 100%; min-height: 250px; padding: 12px; border: 2px solid #e0e0e0;
            border-radius: 8px; font-family: 'Courier New', monospace; font-size: 13px;
            resize: vertical; direction: ltr; text-align: left;
        }
        .page { display: none; }
        .page.active { display: block; }
        .nav-bar {
            display: flex; justify-content: space-between; align-items: center;
            padding: 15px 30px; background: #f8f9fa; border-bottom: 2px solid #e0e0e0;
        }
        .nav-bar h2 { font-size: 18px; color: #333; }
        .empty-state {
            text-align: center; padding: 40px; color: #999;
        }
        .empty-state-icon { font-size: 60px; margin-bottom: 15px; }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>🧠 محول المشاريع الذكي إلى APK</h1>
            <p>النسخة النهائية - يقبل جميع الملفات + حفظ سجل البناء + تنزيل مباشر</p>
        </div>

        <!-- شريط التنقل -->
        <div class="nav-bar">
            <h2 id="pageTitle">🏠 الصفحة الرئيسية</h2>
            <button class="btn btn-back" onclick="goHome()" id="backBtn" style="display: none;">
                🏠 العودة للرئيسية
            </button>
        </div>

        <!-- الصفحة الرئيسية -->
        <div class="page active" id="mainPage">
            <div class="content">
                <div class="warning-box">
                    ⚠️ <strong>تنبيه هام:</strong> يجب أن يحتوي GitHub Token على صلاحيات <code>repo</code> و <code>workflow</code>.
                    الموقع يقبل الآن <strong>جميع أنواع الملفات</strong> (ZIP, Java, Kotlin, Dart, Python, HTML, JS, صور...).
                </div>

                <!-- القسم 1: ربط GitHub -->
                <div class="section">
                    <div class="section-title"><span>1</span><span>ربط GitHub</span></div>
                    <div class="input-group">
                        <label>GitHub Token:</label>
                        <input type="password" id="githubToken" placeholder="ghp_xxxxxxxxxxxxxxxxxxxx">
                    </div>
                    <button class="btn btn-primary" onclick="testConnection()">🔗 اختبار الاتصال</button>
                    <button class="btn btn-danger" onclick="clearToken()">🗑️ مسح</button>
                    <div id="connectionStatus" class="status-message"></div>
                </div>

                <!-- القسم 2: المستودع -->
                <div class="section">
                    <div class="section-title"><span>2</span><span>مستودع البناء</span></div>
                    <button class="btn btn-secondary" onclick="refreshRepos()">🔄 تحديث المستودعات</button>
                    <button class="btn btn-primary" onclick="useSelectedRepo()">📌 استخدام المحدد</button>
                    <button class="btn btn-secondary" onclick="createNewRepo()">➕ إنشاء مستودع جديد</button>
                    <div class="repo-list" id="repoList"></div>
                    <div id="repoStatus" class="status-message"></div>
                </div>

                <!-- القسم 3: إضافة المشروع -->
                <div class="section">
                    <div class="section-title"><span>3</span><span>أضف مشروعك (يدعم جميع الأنواع)</span></div>

                    <div class="tabs">
                        <div class="tab active" onclick="switchTab(event, 'files')">📁 ملفات (أي نوع)</div>
                        <div class="tab" onclick="switchTab(event, 'zip')">📦 ملف ZIP</div>
                        <div class="tab" onclick="switchTab(event, 'code')">📝 لصق الكود مباشرة</div>
                    </div>

                    <div id="filesTab" class="tab-content active">
                        <div class="file-upload" id="fileUpload" onclick="document.getElementById('fileInput').click()">
                            <p style="font-size: 40px; margin-bottom: 10px;">📁</p>
                            <p style="color: #666;">انقر هنا لاختيار الملفات أو اسحبها هنا</p>
                            <p style="color: #999; font-size: 12px; margin-top: 10px;">
                                ✅ يقبل: ZIP, Java, Kotlin, Dart, Python, HTML, JS, صور، أي ملف
                            </p>
                        </div>
                        <input type="file" id="fileInput" multiple style="display: none;" onchange="handleFilesUpload(event)">
                    </div>

                    <div id="zipTab" class="tab-content">
                        <div class="file-upload" onclick="document.getElementById('zipInput').click()">
                            <p style="font-size: 40px; margin-bottom: 10px;">📦</p>
                            <p style="color: #666;">اختر ملف ZIP</p>
                            <p style="color: #999; font-size: 12px; margin-top: 10px;">
                                ✅ يدعم جميع ملفات ZIP (أقل من 50 ميجابايت)
                            </p>
                        </div>
                        <input type="file" id="zipInput" accept=".zip,application/zip,application/x-zip-compressed" style="display: none;" onchange="handleZipUpload(event)">
                    </div>

                    <div id="codeTab" class="tab-content">
                        <div class="input-group">
                            <label>اسم الملف (مع الامتداد):</label>
                            <input type="text" id="codeFileName" placeholder="مثال: MainActivity.java أو main.dart" value="Main.java">
                        </div>
                        <div class="input-group">
                            <label>الصق الكود هنا:</label>
                            <textarea id="codeInput" class="code-input" placeholder="الصق كودك هنا... (Java, Kotlin, Dart, Python, HTML, JS, أي لغة)"></textarea>
                        </div>
                        <button class="btn btn-primary" onclick="processCode()">💾 حفظ الكود</button>
                    </div>

                    <div class="file-list" id="fileList"></div>
                    <div class="progress-bar" id="progressBar"><div class="progress-fill" id="progressFill"></div></div>
                    <div id="uploadStatus" class="status-message"></div>

                    <div class="project-info" id="projectInfo">
                        <h3 style="margin-bottom: 15px; color: #333; font-size: 16px;">📊 تحليل المشروع</h3>
                        <div class="info-item"><span class="info-label">النوع المكتشف:</span><span class="info-value" id="projectType">-</span></div>
                        <div class="info-item"><span class="info-label">اللغة الرئيسية:</span><span class="info-value" id="mainLanguage">-</span></div>
                        <div class="info-item"><span class="info-label">عدد الملفات:</span><span class="info-value" id="fileCount">-</span></div>
                        <div class="info-item"><span class="info-label">الحجم الكلي:</span><span class="info-value" id="projectSize">-</span></div>
                        <div class="info-item"><span class="info-label">جاهز للبناء:</span><span class="info-value" id="buildReady">-</span></div>
                    </div>

                    <div style="margin-top: 15px;">
                        <button class="btn btn-success" onclick="analyzeProject()">🔍 فحص وتحليل الملفات</button>
                        <button class="btn btn-danger" onclick="clearAllFiles()">🗑️ مسح جميع الملفات</button>
                    </div>
                </div>

                <!-- القسم 4: إعدادات البناء -->
                <div class="section">
                    <div class="section-title"><span>4</span><span>إعدادات البناء</span></div>
                    <div class="input-group">
                        <label>اسم التطبيق:</label>
                        <input type="text" id="appName" value="MyApp">
                    </div>
                    <div class="input-group">
                        <label>Package ID:</label>
                        <input type="text" id="packageId" value="com.example.myapp">
                    </div>
                    <button class="btn btn-success" onclick="startBuild()" style="width: 100%; font-size: 16px; padding: 15px;" id="buildBtn">
                        ⚡ بدء رفع المشروع وبناء APK
                    </button>
                    <div id="buildStatus" class="status-message"></div>
                </div>

                <!-- القسم 5: سجل العمليات السابقة -->
                <div class="section">
                    <div class="section-title"><span>📜</span><span>سجل عمليات البناء السابقة</span></div>
                    <div id="buildHistory">
                        <div class="empty-state">
                            <div class="empty-state-icon">📭</div>
                            <p>لا توجد عمليات بناء سابقة</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- صفحة التنزيل -->
        <div class="page" id="downloadPage">
            <div class="content">
                <div class="section">
                    <div class="section-title"><span>🎉</span><span>تم الانتهاء من البناء!</span></div>
                    <div id="downloadInfo" style="margin-bottom: 20px;"></div>
                    <div class="download-links show" id="downloadLinks">
                        <a href="#" class="download-link direct" id="directDownloadLink" download>
                            📥 تنزيل APK مباشرة (اضغط هنا)
                        </a>
                        <a href="#" class="download-link" id="githubArtifactLink" target="_blank">
                            📦 فتح صفحة Artifact في GitHub
                        </a>
                        <a href="#" class="download-link" id="buildLink" target="_blank">
                            ⚙️ مراقبة عملية البناء في GitHub
                        </a>
                    </div>
                    <div style="margin-top: 20px; text-align: center;">
                        <button class="btn btn-back" onclick="goHome()">🏠 العودة للصفحة الرئيسية</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        // ============ Global Variables ============
        let githubToken = '';
        let selectedRepo = null;
        let uploadedFiles = [];
        let defaultBranch = 'main';
        let detectedProjectType = null;
        let currentBuildId = null;
        let currentRunId = null;

        // ============ Initialization ============
        document.addEventListener('DOMContentLoaded', () => {
            loadSavedToken();
            setupDragAndDrop();
            loadBuildHistory();
        });

        function loadSavedToken() {
            try {
                const saved = localStorage.getItem('githubToken');
                if (saved) {
                    document.getElementById('githubToken').value = saved;
                    githubToken = saved;
                }
            } catch (err) {
                console.error('Error loading token:', err);
            }
        }

        // ============ Navigation ============
        function showPage(pageId) {
            document.querySelectorAll('.page').forEach(p => p.classList.remove('active'));
            const page = document.getElementById(pageId);
            if (page) {
                page.classList.add('active');
                document.getElementById('backBtn').style.display = pageId === 'mainPage' ? 'none' : 'inline-flex';
                document.getElementById('pageTitle').textContent = pageId === 'mainPage' ? '🏠 الصفحة الرئيسية' : '📥 صفحة التنزيل';
                window.scrollTo(0, 0);
            }
        }

        function goHome() {
            showPage('mainPage');
        }

        // ============ Drag & Drop ============
        function setupDragAndDrop() {
            const el = document.getElementById('fileUpload');
            if (!el) return;
            
            el.addEventListener('dragover', e => {
                e.preventDefault();
                e.stopPropagation();
                el.classList.add('dragover');
            });
            el.addEventListener('dragleave', e => {
                e.preventDefault();
                e.stopPropagation();
                el.classList.remove('dragover');
            });
            el.addEventListener('drop', e => {
                e.preventDefault();
                e.stopPropagation();
                el.classList.remove('dragover');
                if (e.dataTransfer.files.length > 0) {
                    handleMultipleFiles(e.dataTransfer.files);
                }
            });
        }

        function showStatus(id, msg, type) {
            const el = document.getElementById(id);
            if (el) {
                el.innerHTML = msg;
                el.className = 'status-message ' + type;
            }
        }

        function switchTab(event, tabName) {
            if (!event || !event.target) return;
            document.querySelectorAll('.tab').forEach(t => t.classList.remove('active'));
            document.querySelectorAll('.tab-content').forEach(c => c.classList.remove('active'));
            event.target.classList.add('active');
            const tabContent = document.getElementById(tabName + 'Tab');
            if (tabContent) {
                tabContent.classList.add('active');
            }
        }

        // ============ GitHub Functions ============
        async function testConnection() {
            const token = document.getElementById('githubToken').value.trim();
            if (!token) return showStatus('connectionStatus', '❌ الرجاء إدخال التوكن', 'error');
            
            showStatus('connectionStatus', '<span class="spinner"></span> جاري الاختبار...', 'info');
            
            try {
                const res = await fetch('https://api.github.com/user', {
                    headers: {
                        'Authorization': `token ${token}`,
                        'Accept': 'application/vnd.github.v3+json'
                    }
                });
                
                if (res.ok) {
                    const data = await res.json();
                    githubToken = token;
                    try {
                        localStorage.setItem('githubToken', token);
                    } catch (err) {
                        console.error('Error saving token:', err);
                    }
                    showStatus('connectionStatus', `✅ مرحباً ${data.login}. الاتصال ناجح!`, 'success');
                    refreshRepos();
                } else {
                    showStatus('connectionStatus', '❌ فشل الاتصال. تأكد من صحة التوكن وصلاحياته (repo, workflow)', 'error');
                }
            } catch (err) {
                showStatus('connectionStatus', '❌ خطأ في الاتصال: ' + err.message, 'error');
            }
        }

        function clearToken() {
            try {
                localStorage.removeItem('githubToken');
            } catch (err) {
                console.error('Error clearing token:', err);
            }
            document.getElementById('githubToken').value = '';
            githubToken = '';
            showStatus('connectionStatus', 'تم مسح التوكن', 'info');
        }

        async function refreshRepos() {
            if (!githubToken) return showStatus('repoStatus', '❌ اتصل بـ GitHub أولاً', 'error');
            
            showStatus('repoStatus', '<span class="spinner"></span> جاري التحميل...', 'info');
            
            try {
                const res = await fetch('https://api.github.com/user/repos?per_page=50', {
                    headers: {
                        'Authorization': `token ${githubToken}`,
                        'Accept': 'application/vnd.github.v3+json'
                    }
                });
                
                if (res.ok) {
                    const repos = await res.json();
                    const list = document.getElementById('repoList');
                    if (!list) return;
                    
                    list.innerHTML = '';
                    repos.forEach(repo => {
                        const div = document.createElement('div');
                        div.className = 'repo-item';
                        div.innerHTML = `<strong>${repo.name}</strong> <small style="color:#666">(${repo.private ? 'خاص' : 'عام'})</small>`;
                        div.onclick = () => {
                            document.querySelectorAll('.repo-item').forEach(d => d.classList.remove('selected'));
                            div.classList.add('selected');
                            selectedRepo = repo;
                        };
                        list.appendChild(div);
                    });
                    showStatus('repoStatus', `✅ تم تحميل ${repos.length} مستودع`, 'success');
                } else {
                    showStatus('repoStatus', '❌ فشل تحميل المستودعات', 'error');
                }
            } catch (err) {
                showStatus('repoStatus', '❌ خطأ: ' + err.message, 'error');
            }
        }

        function useSelectedRepo() {
            if (!selectedRepo) return showStatus('repoStatus', '❌ اختر مستودعاً أولاً', 'error');
            showStatus('repoStatus', `✅ تم اختيار: ${selectedRepo.name}`, 'success');
        }

        async function createNewRepo() {
            if (!githubToken) return showStatus('repoStatus', '❌ اتصل بـ GitHub أولاً', 'error');
            
            const name = prompt('اسم المستودع الجديد:', 'apk-project-' + Date.now());
            if (!name) return;
            
            showStatus('repoStatus', '<span class="spinner"></span> جاري الإنشاء...', 'info');
            
            try {
                const res = await fetch('https://api.github.com/user/repos', {
                    method: 'POST',
                    headers: {
                        'Authorization': `token ${githubToken}`,
                        'Content-Type': 'application/json',
                        'Accept': 'application/vnd.github.v3+json'
                    },
                    body: JSON.stringify({
                        name: name,
                        auto_init: true,
                        private: false
                    })
                });
                
                if (res.ok) {
                    selectedRepo = await res.json();
                    showStatus('repoStatus', `✅ تم إنشاء ${selectedRepo.name}`, 'success');
                    refreshRepos();
                } else {
                    const err = await res.json().catch(() => ({}));
                    showStatus('repoStatus', '❌ فشل الإنشاء: ' + (err.message || 'خطأ غير معروف'), 'error');
                }
            } catch (err) {
                showStatus('repoStatus', '❌ خطأ: ' + err.message, 'error');
            }
        }

        // ============ File Handling ============
        function handleFilesUpload(e) {
            if (e.target.files.length > 0) {
                handleMultipleFiles(e.target.files);
            }
        }

        async function handleMultipleFiles(files) {
            showStatus('uploadStatus', '<span class="spinner"></span> جاري قراءة الملفات...', 'info');
            
            let successCount = 0;
            let errorCount = 0;
            
            for (const file of files) {
                try {
                    const content = await fileToBase64(file);
                    uploadedFiles.push({
                        name: file.name,
                        content: content,
                        size: file.size,
                        isBinary: isBinaryFile(file.name),
                        type: file.type
                    });
                    successCount++;
                } catch (err) {
                    console.error('Error reading file:', file.name, err);
                    errorCount++;
                }
            }
            
            renderFileList();
            
            if (errorCount > 0) {
                showStatus('uploadStatus', `⚠️ تم إضافة ${successCount} ملف بنجاح، فشل ${errorCount} ملف`, 'info');
            } else {
                showStatus('uploadStatus', `✅ تم إضافة ${successCount} ملف بنجاح`, 'success');
            }
        }

        async function handleZipUpload(e) {
            const file = e.target.files[0];
            if (!file) return;
            
            // التحقق من الامتداد
            const fileName = file.name.toLowerCase();
            const isValidZip = fileName.endsWith('.zip') || 
                              file.type === 'application/zip' || 
                              file.type === 'application/x-zip-compressed' ||
                              file.type === 'application/x-zip';
            
            if (!isValidZip) {
                return showStatus('uploadStatus', '❌ يجب أن يكون ملف ZIP. الامتداد المقبول: .zip', 'error');
            }

            if (file.size > 50 * 1024 * 1024) {
                return showStatus('uploadStatus', '❌ حجم الملف يتجاوز 50 ميجابايت. الرجاء استخدام ملف أصغر.', 'error');
            }

            showStatus('uploadStatus', '<span class="spinner"></span> جاري فك ضغط ZIP...', 'info');
            const bar = document.getElementById('progressBar');
            const fill = document.getElementById('progressFill');
            if (bar) bar.style.display = 'block';
            if (fill) fill.style.width = '20%';

            try {
                const zip = new JSZip();
                const zipData = await zip.loadAsync(file);
                if (fill) fill.style.width = '50%';
                
                let count = 0;
                const entries = Object.entries(zipData.files);
                
                for (let i = 0; i < entries.length; i++) {
                    const [path, entry] = entries[i];
                    if (!entry.dir) {
                        try {
                            const content = await entry.async('base64');
                            const size = entry._data ? (entry._data.uncompressedSize || 0) : 0;
                            
                            uploadedFiles.push({
                                name: path,
                                content: content,
                                size: size,
                                isBinary: isBinaryFile(path)
                            });
                            count++;
                        } catch (e) {
                            console.warn('Failed to extract:', path, e);
                        }
                    }
                    
                    // تحديث شريط التقدم
                    if (fill) {
                        const progress = 50 + ((i + 1) / entries.length) * 50;
                        fill.style.width = progress + '%';
                    }
                }

                renderFileList();
                if (fill) fill.style.width = '100%';
                showStatus('uploadStatus', `✅ تم استخراج ${count} ملف من ZIP بنجاح`, 'success');
                
                setTimeout(() => {
                    if (bar) bar.style.display = 'none';
                    if (fill) fill.style.width = '0%';
                }, 1000);
            } catch (err) {
                showStatus('uploadStatus', '❌ فشل فك ضغط ZIP: ' + err.message + '<br>تأكد أن الملف ليس تالفاً أو محمياً بكلمة مرور.', 'error');
                if (bar) bar.style.display = 'none';
                if (fill) fill.style.width = '0%';
            }
        }

        function processCode() {
            const code = document.getElementById('codeInput').value;
            const fileName = document.getElementById('codeFileName').value.trim();
            
            if (!code.trim()) return showStatus('uploadStatus', '❌ الرجاء إدخال الكود', 'error');
            if (!fileName) return showStatus('uploadStatus', '❌ الرجاء إدخال اسم الملف', 'error');

            try {
                // تحويل النص إلى base64 بطريقة آمنة تدعم جميع الأحرف
                const base64 = btoa(unescape(encodeURIComponent(code)));
                
                uploadedFiles.push({
                    name: fileName,
                    content: base64,
                    size: new Blob([code]).size,
                    isBinary: false
                });
                
                renderFileList();
                showStatus('uploadStatus', `✅ تم حفظ الكود في ${fileName}`, 'success');
                
                // مسح حقل الكود
                document.getElementById('codeInput').value = '';
            } catch (err) {
                showStatus('uploadStatus', '❌ خطأ في حفظ الكود: ' + err.message, 'error');
            }
        }

        function renderFileList() {
            const list = document.getElementById('fileList');
            if (!list) return;
            
            list.innerHTML = '';
            
            if (uploadedFiles.length === 0) {
                list.innerHTML = '<p style="color: #999; text-align: center; padding: 20px;">لا توجد ملفات مضافة</p>';
                return;
            }
            
            uploadedFiles.forEach((file, idx) => {
                const item = document.createElement('div');
                item.className = 'file-item';
                item.innerHTML = `
                    <span class="file-name">${file.isBinary ? '📦' : '📄'} ${file.name}</span>
                    <span class="file-size">${formatSize(file.size)}</span>
                    <button class="btn btn-danger" style="padding: 5px 10px; font-size: 12px;" onclick="removeFile(${idx})">حذف</button>
                `;
                list.appendChild(item);
            });
        }

        function removeFile(idx) {
            if (idx >= 0 && idx < uploadedFiles.length) {
                uploadedFiles.splice(idx, 1);
                renderFileList();
            }
        }

        function clearAllFiles() {
            uploadedFiles = [];
            detectedProjectType = null;
            renderFileList();
            const projectInfo = document.getElementById('projectInfo');
            if (projectInfo) {
                projectInfo.classList.remove('show');
            }
            showStatus('uploadStatus', 'تم مسح جميع الملفات', 'info');
        }

        function analyzeProject() {
            if (uploadedFiles.length === 0) {
                return showStatus('uploadStatus', '❌ لا توجد ملفات للفحص', 'error');
            }
            
            showStatus('uploadStatus', '<span class="spinner"></span> جاري تحليل الملفات...', 'info');

            const names = uploadedFiles.map(f => f.name.toLowerCase());
            const exts = {};
            
            names.forEach(n => {
                const parts = n.split('.');
                if (parts.length > 1) {
                    const ext = parts.pop();
                    exts[ext] = (exts[ext] || 0) + 1;
                }
            });

            let type = 'غير محدد', lang = 'غير محدد', ready = '❌ لا';

            if (names.some(n => n.includes('pubspec.yaml')) && names.some(n => n.includes('main.dart'))) {
                type = 'Flutter'; lang = 'Dart'; ready = '✅ نعم';
            } else if (names.some(n => n.includes('build.gradle')) && names.some(n => n.includes('androidmanifest.xml'))) {
                type = 'Android Native';
                lang = (exts['java'] || 0) > (exts['kt'] || 0) ? 'Java' : 'Kotlin';
                ready = '✅ نعم';
            } else if (names.some(n => n.includes('package.json')) && names.some(n => n.includes('android/'))) {
                type = 'React Native'; lang = 'JavaScript'; ready = '✅ نعم';
            } else if (exts['html'] > 0) {
                type = 'Web App'; lang = 'HTML/JS'; ready = '⚠️ يحتاج تغليف';
            } else if (exts['py'] > 0) {
                type = 'Python'; lang = 'Python'; ready = '⚠️ يحتاج Kivy';
            } else if (exts['java'] > 0 || exts['kt'] > 0) {
                type = 'Java/Kotlin Code';
                lang = exts['java'] > 0 ? 'Java' : 'Kotlin';
                ready = '⚠️ يحتاج تكوين Android';
            } else if (exts['dart'] > 0) {
                type = 'Dart Code'; lang = 'Dart'; ready = '⚠️ يحتاج pubspec.yaml';
            }

            detectedProjectType = { type, lang, ready };

            const totalSize = uploadedFiles.reduce((s, f) => s + (f.size || 0), 0);
            
            const projectType = document.getElementById('projectType');
            const mainLanguage = document.getElementById('mainLanguage');
            const fileCount = document.getElementById('fileCount');
            const projectSize = document.getElementById('projectSize');
            const buildReady = document.getElementById('buildReady');
            const projectInfo = document.getElementById('projectInfo');
            
            if (projectType) projectType.textContent = type;
            if (mainLanguage) mainLanguage.textContent = lang;
            if (fileCount) fileCount.textContent = uploadedFiles.length + ' ملف';
            if (projectSize) projectSize.textContent = formatSize(totalSize);
            if (buildReady) buildReady.textContent = ready;
            if (projectInfo) projectInfo.classList.add('show');

            showStatus('uploadStatus', `✅ التحليل مكتمل: ${type}`, 'success');
        }

        // ============ Build ============
        async function startBuild() {
            if (!githubToken) return showStatus('buildStatus', '❌ اتصل بـ GitHub أولاً', 'error');
            if (!selectedRepo) return showStatus('buildStatus', '❌ اختر مستودعاً أولاً', 'error');
            if (uploadedFiles.length === 0) return showStatus('buildStatus', '❌ أضف ملفات أولاً', 'error');

            const appName = document.getElementById('appName').value.trim() || 'MyApp';
            const buildId = 'build_' + Date.now();
            currentBuildId = buildId;

            const btn = document.getElementById('buildBtn');
            if (btn) {
                btn.disabled = true;
                btn.innerHTML = '<span class="spinner"></span> جاري الرفع والبناء...';
            }

            // حفظ في السجل كـ "قيد التنفيذ"
            saveToHistory({
                id: buildId,
                appName: appName,
                date: new Date().toISOString(),
                status: 'pending',
                repo: selectedRepo.full_name,
                filesCount: uploadedFiles.length
            });

            try {
                showStatus('buildStatus', '<span class="spinner"></span> الخطوة 1/4: تحديد الفرع الرئيسي...', 'info');
                
                const repoRes = await fetch(`https://api.github.com/repos/${selectedRepo.full_name}`, {
                    headers: {
                        'Authorization': `token ${githubToken}`,
                        'Accept': 'application/vnd.github.v3+json'
                    }
                });
                
                if (!repoRes.ok) {
                    throw new Error('فشل في الوصول للمستودع');
                }
                
                const repoData = await repoRes.json();
                defaultBranch = repoData.default_branch || 'main';

                showStatus('buildStatus', '<span class="spinner"></span> الخطوة 2/4: رفع الملفات إلى GitHub...', 'info');
                
                for (const file of uploadedFiles) {
                    if (file.size > 50 * 1024 * 1024) {
                        console.warn('Skipping large file:', file.name);
                        continue;
                    }
                    await uploadFileToRepo(file.name, file.content);
                }

                showStatus('buildStatus', '<span class="spinner"></span> الخطوة 3/4: إنشاء ملف البناء...', 'info');
                const workflow = generateWorkflow();
                await uploadFileToRepo('.github/workflows/build.yml', btoa(workflow));

                showStatus('buildStatus', '<span class="spinner"></span> الخطوة 4/4: تشغيل البناء...', 'info');
                
                const triggerRes = await fetch(`https://api.github.com/repos/${selectedRepo.full_name}/actions/workflows/build.yml/dispatches`, {
                    method: 'POST',
                    headers: {
                        'Authorization': `token ${githubToken}`,
                        'Content-Type': 'application/json',
                        'Accept': 'application/vnd.github.v3+json'
                    },
                    body: JSON.stringify({ ref: defaultBranch })
                });
                
                if (!triggerRes.ok) {
                    throw new Error('فشل تشغيل البناء. تأكد من صلاحية workflow في التوكن.');
                }

                await new Promise(r => setTimeout(r, 3000));
                
                const runsRes = await fetch(`https://api.github.com/repos/${selectedRepo.full_name}/actions/runs?per_page=1`, {
                    headers: {
                        'Authorization': `token ${githubToken}`,
                        'Accept': 'application/vnd.github.v3+json'
                    }
                });
                
                const runsData = await runsRes.json();
                
                if (!runsData.workflow_runs || runsData.workflow_runs.length === 0) {
                    throw new Error('لم يتم العثور على عملية بناء.');
                }
                
                const runId = runsData.workflow_runs[0].id;
                currentRunId = runId;

                // تحديث السجل
                updateHistory(buildId, { runId: runId, status: 'pending' });

                showStatus('buildStatus', `✅ تم بدء البناء! <a href="https://github.com/${selectedRepo.full_name}/actions/runs/${runId}" target="_blank" style="color:#0c5460; font-weight:bold;">متابعة في GitHub</a>`, 'info');
                monitorBuild(runId, buildId, appName);

            } catch (err) {
                showStatus('buildStatus', '❌ خطأ: ' + err.message, 'error');
                updateHistory(buildId, { status: 'failed', error: err.message });
                
                if (btn) {
                    btn.disabled = false;
                    btn.innerHTML = '⚡ بدء رفع المشروع وبناء APK';
                }
            }
        }

        function generateWorkflow() {
            const type = detectedProjectType ? detectedProjectType.type : '';
            let buildSteps = '';

            if (type === 'Flutter') {
                buildSteps = `
    - name: Setup Flutter
      uses: subosito/flutter-action@v2
      with:
        flutter-version: '3.x'
    - name: Build APK
      run: |
        flutter pub get
        flutter build apk --release`;
            } else if (type === 'Android Native') {
                buildSteps = `
    - name: Build APK
      run: |
        if [ -f "gradlew" ]; then chmod +x gradlew; ./gradlew assembleRelease; fi`;
            } else if (type === 'React Native') {
                buildSteps = `
    - name: Setup Node
      uses: actions/setup-node@v3
      with:
        node-version: '18'
    - name: Install deps
      run: npm install
    - name: Build Android
      run: |
        cd android && chmod +x gradlew && ./gradlew assembleRelease`;
            } else {
                buildSteps = `
    - name: Detect and Build
      run: |
        if [ -f "pubspec.yaml" ]; then
          flutter pub get && flutter build apk --release
        elif [ -f "build.gradle" ]; then
          [ -f "gradlew" ] && chmod +x gradlew && ./gradlew assembleRelease
        elif [ -f "package.json" ]; then
          npm install
          [ -d "android" ] && cd android && chmod +x gradlew && ./gradlew assembleRelease
        else
          mkdir -p output
          echo "لم يتم اكتشاف هيكل مشروع صالح" > output/README.txt
        fi`;
            }

            return `name: Build APK
on:
  push:
    branches: [ ${defaultBranch} ]
  workflow_dispatch:
jobs:
  build:
    runs-on: ubuntu-latest
    steps:
    - uses: actions/checkout@v3
    - name: Setup Java
      uses: actions/setup-java@v3
      with:
        distribution: 'zulu'
        java-version: '17'
${buildSteps}
    - name: Upload APK
      if: always()
      uses: actions/upload-artifact@v3
      with:
        name: app-release
        path: |
          **/*.apk
          **/*.txt
          output/**
`;
        }

        async function uploadFileToRepo(path, content) {
            const url = `https://api.github.com/repos/${selectedRepo.full_name}/contents/${path}`;
            
            // التحقق مما إذا كان الملف موجوداً مسبقاً
            let sha = null;
            try {
                const checkRes = await fetch(url, {
                    headers: {
                        'Authorization': `token ${githubToken}`,
                        'Accept': 'application/vnd.github.v3+json'
                    }
                });
                
                if (checkRes.ok) {
                    const existing = await checkRes.json();
                    sha = existing.sha;
                }
            } catch (err) {
                // الملف غير موجود، نتابع
            }

            const body = {
                message: `Add/Update ${path}`,
                content: content,
                branch: defaultBranch
            };
            
            if (sha) {
                body.sha = sha;
            }

            const res = await fetch(url, {
                method: 'PUT',
                headers: {
                    'Authorization': `token ${githubToken}`,
                    'Content-Type': 'application/json',
                    'Accept': 'application/vnd.github.v3+json'
                },
                body: JSON.stringify(body)
            });
            
            if (!res.ok) {
                const err = await res.json().catch(() => ({}));
                throw new Error(`فشل رفع ${path}: ${err.message || res.statusText}`);
            }
        }

        async function monitorBuild(runId, buildId, appName) {
            let attempts = 0;
            const maxAttempts = 60;
            
            const check = async () => {
                attempts++;
                
                try {
                    const res = await fetch(`https://api.github.com/repos/${selectedRepo.full_name}/actions/runs/${runId}`, {
                        headers: {
                            'Authorization': `token ${githubToken}`,
                            'Accept': 'application/vnd.github.v3+json'
                        }
                    });
                    
                    if (!res.ok) {
                        throw new Error('فشل في جلب حالة البناء');
                    }
                    
                    const data = await res.json();

                    if (data.status === 'completed') {
                        const btn = document.getElementById('buildBtn');
                        if (btn) {
                            btn.disabled = false;
                            btn.innerHTML = '⚡ بدء رفع المشروع وبناء APK';
                        }

                        if (data.conclusion === 'success') {
                            updateHistory(buildId, { status: 'success', runId: runId });
                            await showDownloadPage(runId, appName, buildId);
                        } else {
                            updateHistory(buildId, { status: 'failed', runId: runId, error: data.conclusion });
                            showStatus('buildStatus', `❌ فشل البناء. <a href="https://github.com/${selectedRepo.full_name}/actions/runs/${runId}" target="_blank">راجع السجلات</a>`, 'error');
                        }
                        return;
                    }

                    if (attempts < maxAttempts) {
                        setTimeout(check, 10000);
                    } else {
                        updateHistory(buildId, { status: 'timeout', runId: runId });
                        showStatus('buildStatus', '⏱️ انتهى وقت الانتظار. يمكنك المتابعة من GitHub.', 'info');
                        
                        const btn = document.getElementById('buildBtn');
                        if (btn) {
                            btn.disabled = false;
                            btn.innerHTML = '⚡ بدء رفع المشروع وبناء APK';
                        }
                    }
                } catch (err) {
                    console.error('Error monitoring build:', err);
                    if (attempts < maxAttempts) {
                        setTimeout(check, 10000);
                    }
                }
            };
            
            check();
        }

        // ============ Download Page ============
        async function showDownloadPage(runId, appName, buildId) {
            showStatus('buildStatus', '🎉 تم البناء بنجاح! جاري تجهيز روابط التنزيل...', 'success');

            try {
                const artRes = await fetch(`https://api.github.com/repos/${selectedRepo.full_name}/actions/runs/${runId}/artifacts`, {
                    headers: {
                        'Authorization': `token ${githubToken}`,
                        'Accept': 'application/vnd.github.v3+json'
                    }
                });
                
                const artData = await artRes.json();

                const downloadInfo = document.getElementById('downloadInfo');
                if (downloadInfo) {
                    downloadInfo.innerHTML = `
                        <div style="background: #d4edda; padding: 20px; border-radius: 10px; border: 2px solid #28a745;">
                            <h3 style="color: #155724; margin-bot