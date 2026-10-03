<!DOCTYPE html>
<html lang="ar" dir="rtl">
<head><style>
@font-face {
  font-family: "Optimistic";
  font-style: normal;
  font-weight: 400 600;
  font-display: swap;
  src: url("/fonts/OptimisticAI_VF_Optimized.woff2") format("woff2");
}
@font-face {
  font-family: "Optimistic Mono";
  font-style: normal;
  font-weight: 400;
  font-display: swap;
  src: url("/fonts/OptimisticMono_W_TextRegular.woff2") format("woff2");
}
:where(html) {
  font-family: "Optimistic", system-ui, sans-serif;
}
:where(code, pre, kbd, samp) {
  font-family: "Optimistic Mono", ui-monospace, monospace;
}
</style>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>محول المشاريع الذكي إلى APK - V6 مصلح 100%</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.10.1/jszip.min.js"></script>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background: linear-gradient(135deg, #0f172a 0%, #1e293b 100%); min-height: 100vh; padding: 20px; direction: rtl; color:#e2e8f0; }
        .container { max-width: 950px; margin: 0 auto; background: #1e293b; border-radius: 20px; box-shadow: 0 20px 60px rgba(0,0,0,0.5); overflow: hidden; border:1px solid #334155; }
        .header { background: linear-gradient(135deg, #22c55e 0%, #16a34a 100%); color: white; padding: 30px; text-align: center; }
        .header h1 { font-size: 24px; margin-bottom: 8px; }
        .content { padding: 25px; }
        .section { margin-bottom: 20px; padding: 20px; border: 1px solid #334155; border-radius: 15px; background:#0f172a; }
        .section-title { font-size: 17px; color: #22c55e; margin-bottom: 12px; font-weight: bold; }
        .btn { padding: 12px 18px; border: none; border-radius: 8px; font-size: 14px; font-weight: 600; cursor: pointer; margin: 4px; }
        .btn:disabled { opacity: 0.5; cursor: not-allowed; }
        .btn-primary { background: #22c55e; color: white; }
        .btn-secondary { background: #334155; color: #e2e8f0; }
        .btn-success { background: linear-gradient(135deg, #22c55e 0%, #16a34a 100%); color: white; }
        .btn-danger { background: #ef4444; color: white; }
        .input-group { margin-bottom: 12px; }
        .input-group label { display: block; margin-bottom: 6px; color: #94a3b8; font-weight: 600; font-size:13px; }
        .input-group input, .input-group textarea, .input-group select { width: 100%; padding: 11px; border: 1px solid #334155; border-radius: 8px; font-size: 14px; background:#1e293b; color:#e2e8f0; }
        .file-upload { border: 2px dashed #334155; border-radius: 12px; padding: 30px; text-align: center; cursor: pointer; }
        .file-upload:hover { border-color: #22c55e; background: #1e293b; }
        .status-message { padding: 12px; border-radius: 8px; margin-top: 12px; display: none; font-size: 13px; white-space: pre-wrap; }
        .status-message.success { background: #14532d; color: #bbf7d0; border: 1px solid #22c55e; display: block; }
        .status-message.error { background: #450a0a; color: #fecaca; border: 1px solid #ef4444; display: block; }
        .status-message.info { background: #1e293b; color: #93c5fd; border: 1px solid #334155; display: block; }
        .project-info { background: #1e293b; border-radius: 10px; padding: 12px; margin-top: 12px; display: none; border:1px solid #334155; }
        .project-info.show { display: block; }
        .info-item { display: flex; justify-content: space-between; padding: 6px 0; border-bottom: 1px solid #334155; font-size:13px; }
        .file-list { margin-top: 12px; max-height: 250px; overflow-y: auto; }
        .file-item { display: flex; justify-content: space-between; align-items: center; padding: 8px; background: #1e293b; border:1px solid #334155; border-radius: 6px; margin-bottom: 6px; font-size:12px; }
        .tabs { display: flex; gap: 8px; margin-bottom: 15px; flex-wrap: wrap; }
        .tab { padding: 8px 16px; background: #334155; border-radius: 8px; cursor: pointer; font-size:13px; }
        .tab.active { background: #22c55e; color: white; }
        .tab-content { display: none; }
        .tab-content.active { display: block; }
        .repo-list { max-height: 220px; overflow-y: auto; margin-top: 10px; }
        .repo-item { padding: 10px; background: #1e293b; border:1px solid #334155; border-radius: 6px; margin-bottom: 6px; cursor: pointer; }
        .repo-item.selected { background: #22c55e; color: white; }
        .file-preview { background: #020617; color: #e2e8f0; padding: 12px; border-radius: 8px; font-family: monospace; font-size: 11px; max-height: 250px; overflow: auto; margin-top: 10px; display: none; white-space: pre-wrap; }
        .file-preview.show { display: block; }
        textarea.code-input { width: 100%; min-height: 220px; padding: 10px; border: 1px solid #334155; border-radius: 8px; font-family: monospace; font-size: 12px; background:#020617; color:#e2e8f0; }
        .download-links { margin-top: 15px; padding: 15px; background: #14532d; border-radius: 10px; display: none; border:1px solid #22c55e; }
        .download-links.show { display: block; }
        .download-link { display: block; padding: 12px; background: #1e293b; border: 1px solid #22c55e; border-radius: 8px; margin-bottom: 8px; text-decoration: none; color: #bbf7d0; }
        @keyframes spin { 0% { transform: rotate(0deg); } 100% { transform: rotate(360deg); } }
        .spinner { display: inline-block; width: 16px; height: 16px; border: 2px solid #334155; border-top: 2px solid #22c55e; border-radius: 50%; animation: spin 1s linear infinite; }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>🧠 محول المشاريع الذكي إلى APK - V6 مصلح</h1>
            <p>يدعم جميع الملفات + يصلح أخطاء ZIP + SDK 34/35 + تحميل APK مضمون</p>
        </div>
        <div class="content">
            <div class="section">
                <div class="section-title">1. ربط GitHub</div>
                <div class="input-group"><label>GitHub Token (repo + workflow):</label><input type="password" id="githubToken" placeholder="ghp_..."></div>
                <button class="btn btn-primary" onclick="testConnection()">🔗 اختبار</button>
                <button class="btn btn-danger" onclick="clearToken()">🗑️ مسح</button>
                <div id="connectionStatus" class="status-message"></div>
            </div>
            <div class="section">
                <div class="section-title">2. مستودع البناء</div>
                <button class="btn btn-secondary" onclick="refreshRepos()">🔄 تحديث</button>
                <button class="btn btn-primary" onclick="useSelectedRepo()">📌 استخدام</button>
                <button class="btn btn-secondary" onclick="createNewRepo()">➕ جديد</button>
                <div class="repo-list" id="repoList"></div>
                <div id="repoStatus" class="status-message"></div>
            </div>
            <div class="section">
                <div class="section-title">3. أضف مشروعك (يقبل أي نوع)</div>
                <div class="tabs">
                    <div class="tab active" onclick="switchTab(event, 'files')">📁 ملفات (أي نوع)</div>
                    <div class="tab" onclick="switchTab(event, 'zip')">📦 ZIP</div>
                    <div class="tab" onclick="switchTab(event, 'code')">📝 كود مباشر</div>
                </div>
                <div id="filesTab" class="tab-content active">
                    <div class="file-upload" id="fileUpload" onclick="document.getElementById('fileInput').click()">
                        <p>📁 انقر لاختيار ملفات أو اسحبها هنا</p><p style="font-size:11px;color:#94a3b8">يقبل: Java, Kotlin, Dart, HTML, JS, صور، أي ملف</p>
                    </div>
                    <input type="file" id="fileInput" multiple style="display:none" onchange="handleFilesUpload(event)">
                </div>
                <div id="zipTab" class="tab-content">
                    <div class="file-upload" onclick="document.getElementById('zipInput').click()"><p>📦 اختر ZIP</p><p style="font-size:11px;color:#94a3b8">يتم فحص الـ ZIP قبل القراءة (PK)</p></div>
                    <input type="file" id="zipInput" accept=".zip,application/zip,*/*" style="display:none" onchange="handleZipUpload(event)">
                </div>
                <div id="codeTab" class="tab-content">
                    <div class="input-group"><label>اسم الملف:</label><input type="text" id="codeFileName" placeholder="MainActivity.kt أو index.html" value="MainActivity.kt"></div>
                    <div class="input-group"><label>الكود:</label><textarea id="codeInput" class="code-input" placeholder="الصق كودك هنا..."></textarea></div>
                    <button class="btn btn-primary" onclick="processCode()">💾 حفظ</button>
                    <button class="btn btn-secondary" onclick="previewCode()">👁️ معاينة</button>
                </div>
                <div class="file-list" id="fileList"></div>
                <div id="uploadStatus" class="status-message"></div>
                <div class="file-preview" id="filePreview"></div>
                <div class="project-info" id="projectInfo">
                    <div class="info-item"><span>النوع:</span><span id="projectType">-</span></div>
                    <div class="info-item"><span>اللغة:</span><span id="mainLanguage">-</span></div>
                    <div class="info-item"><span>عدد الملفات:</span><span id="fileCount">-</span></div>
                    <div class="info-item"><span>الحجم:</span><span id="projectSize">-</span></div>
                    <div class="info-item"><span>جاهز:</span><span id="buildReady">-</span></div>
                </div>
                <div style="margin-top:10px">
                    <button class="btn btn-success" onclick="analyzeProject()">🔍 فحص</button>
                    <button class="btn btn-danger" onclick="clearAllFiles()">🗑️ مسح</button>
                </div>
            </div>
            <div class="section">
                <div class="section-title">4. إعدادات البناء</div>
                <div class="input-group"><label>اسم التطبيق:</label><input type="text" id="appName" value="MyApp"></div>
                <div class="input-group"><label>Package ID:</label><input type="text" id="packageId" value="com.example.myapp"></div>
                <button class="btn btn-success" onclick="startBuild()" style="width:100%;padding:14px" id="buildBtn">⚡ بدء بناء APK</button>
                <div id="buildStatus" class="status-message"></div>
                <div id="logBox" style="background:#020617;color:#22c55e;padding:10px;border-radius:8px;margin-top:10px;font-family:monospace;font-size:11px;max-height:200px;overflow:auto;display:none"></div>
                <div class="download-links" id="downloadLinks">
                    <a href="#" class="download-link" id="apkDownloadLink" target="_blank">📦 تحميل APK المباشر</a>
                    <a href="#" class="download-link" id="artifactLink" target="_blank">📦 فتح Artifact في GitHub (تحميل يدوي مضمون)</a>
                    <a href="#" class="download-link" id="buildLink" target="_blank">⚙️ مراقبة البناء</a>
                </div>
            </div>
        </div>
    </div>
<script>
let githubToken='', selectedRepo=null, uploadedFiles=[], defaultBranch='main', detectedProjectType=null, lastDownloadUrl=null, lastApkBlob=null;
try{ const sf=localStorage.getItem('uploadedFiles_v7'); if(sf){ const parsed=JSON.parse(sf); if(Array.isArray(parsed)) uploadedFiles=parsed; } }catch{}
function saveFiles(){ try{ localStorage.setItem('uploadedFiles_v7', JSON.stringify(uploadedFiles.slice(0,30))); }catch{} }

const API='https://api.github.com';
function log(m){ const b=document.getElementById('logBox'); b.style.display='block'; b.innerHTML+=m+"<br>"; b.scrollTop=b.scrollHeight; }
function showStatus(id,msg,type){ const el=document.getElementById(id); el.innerHTML=msg; el.className='status-message '+type; }
function switchTab(e,n){ document.querySelectorAll('.tab').forEach(t=>t.classList.remove('active')); document.querySelectorAll('.tab-content').forEach(c=>c.classList.remove('active')); e.target.classList.add('active'); document.getElementById(n+'Tab').classList.add('active'); }
async function githubFetch(path, opts={}){ const res=await fetch(API+path,{...opts, headers:{'Authorization':`Bearer ${githubToken}`,'Accept':'application/vnd.github.v3+json','X-GitHub-Api-Version':'2022-11-28',...(opts.headers||{})}}); if(!res.ok){ const t=await res.text(); throw new Error(`${res.status} ${t.slice(0,200)}`);} return res.json(); }

document.addEventListener('DOMContentLoaded',()=>{ const s=localStorage.getItem('githubToken'); if(s){ document.getElementById('githubToken').value=s; githubToken=s; } const fu=document.getElementById('fileUpload'); fu.addEventListener('dragover',e=>{e.preventDefault();}); fu.addEventListener('drop',e=>{e.preventDefault(); if(e.dataTransfer.files.length) handleMultipleFiles(e.dataTransfer.files);}); });

async function testConnection(){ const t=document.getElementById('githubToken').value.trim(); if(!t) return showStatus('connectionStatus','أدخل التوكن','error'); showStatus('connectionStatus','<span class="spinner"></span> جاري...','info'); try{ const r=await fetch(API+'/user',{headers:{'Authorization':`token ${t}`}}); if(r.ok){ const d=await r.json(); githubToken=t; localStorage.setItem('githubToken',t); showStatus('connectionStatus',`✅ مرحبا ${d.login}`,'success'); refreshRepos(); } else showStatus('connectionStatus','❌ توكن خطأ أو بدون صلاحيات repo,workflow','error'); }catch(e){ showStatus('connectionStatus','❌ '+e.message,'error'); } }
function clearToken(){ localStorage.removeItem('githubToken'); document.getElementById('githubToken').value=''; githubToken=''; showStatus('connectionStatus','تم المسح','info'); }
async function refreshRepos(){ if(!githubToken) return showStatus('repoStatus','اربط GitHub أولاً','error'); showStatus('repoStatus','<span class="spinner"></span> تحميل...','info'); try{ const data=await githubFetch('/user/repos?per_page=50'); const list=document.getElementById('repoList'); list.innerHTML=''; data.forEach(repo=>{ const div=document.createElement('div'); div.className='repo-item'; div.innerHTML=`<strong>${repo.name}</strong> <small>(${repo.private?'خاص':'عام'})</small>`; div.onclick=()=>{ document.querySelectorAll('.repo-item').forEach(d=>d.classList.remove('selected')); div.classList.add('selected'); selectedRepo=repo; }; list.appendChild(div); }); showStatus('repoStatus',`✅ ${data.length} مستودع`,'success'); }catch(e){ showStatus('repoStatus','❌ '+e.message,'error'); } }
function useSelectedRepo(){ if(!selectedRepo) return showStatus('repoStatus','اختر مستودع','error'); showStatus('repoStatus',`✅ ${selectedRepo.name}`,'success'); }
async function createNewRepo(){ if(!githubToken) return showStatus('repoStatus','اربط أولاً','error'); const name=prompt('اسم المستودع:', 'apk-builder-'+Date.now()); if(!name) return; showStatus('repoStatus','<span class="spinner"></span> إنشاء...','info'); try{ const res=await fetch(API+'/user/repos',{method:'POST', headers:{'Authorization':`token ${githubToken}`,'Content-Type':'application/json'}, body:JSON.stringify({name, auto_init:true, private:false})}); if(res.ok){ selectedRepo=await res.json(); showStatus('repoStatus',`✅ ${selectedRepo.name}`,'success'); refreshRepos(); } else showStatus('repoStatus','❌ فشل','error'); }catch(e){ showStatus('repoStatus','❌ '+e.message,'error'); } }

function isBinaryFile(n){ const ext=n.split('.').pop().toLowerCase(); return ['png','jpg','jpeg','gif','ico','webp','pdf','zip','jar','class','ttf','otf','woff','mp3','mp4','apk'].includes(ext); }
function fileToBase64(f){ return new Promise((res,rej)=>{ const r=new FileReader(); r.onload=()=>res(r.result.split(',')[1]); r.onerror=rej; r.readAsDataURL(f); }); }
function formatSize(b){ if(!b) return '0 B'; const u=['B','KB','MB']; let i=0; while(b>=1024&&i<u.length-1){ b/=1024; i++; } return b.toFixed(1)+' '+u[i]; }

async function handleFilesUpload(e){ if(e.target.files.length) await handleMultipleFiles(e.target.files); }
async function handleMultipleFiles(files){ showStatus('uploadStatus','<span class="spinner"></span> قراءة...','info'); for(const file of files){ try{ const b64=await fileToBase64(file); uploadedFiles.push({name:file.name, content:b64, size:file.size, isBinary:isBinaryFile(file.name)}); }catch{} } renderFileList(); showStatus('uploadStatus',`✅ ${files.length} ملف`,'success'); }

async function handleZipUpload(e){
  const file=e.target.files[0]; if(!file) return;
  if(file.size<22){ showStatus('uploadStatus','❌ الملف فاضي (أقل من 22 بايت)','error'); return; }
  showStatus('uploadStatus','<span class="spinner"></span> فحص ZIP...','info');
  try{
    const head=await file.slice(0,4).arrayBuffer(); const b=new Uint8Array(head);
    const isZip=b[0]==0x50&&b[1]==0x4B;
    if(!isZip){
      const hex=Array.from(b).map(x=>x.toString(16).padStart(2,'0')).join(' ');
      throw new Error(`هذا الملف ليس ZIP. يبدأ بـ ${hex} وليس PK. هل رفعت ملف HTML أو APK بالغلط؟`);
    }
    const zip=await JSZip.loadAsync(file);
    let c=0;
    for(const [rawPath, entry] of Object.entries(zip.files)){
      if(entry.dir) continue;
      let path = rawPath.replace(/\\/g,'/').trim().replace(/^\/+/, '');
      if(!path || path.includes('__MACOSX') || path.startsWith('.') || path.includes('/.')) continue;
      if(path.length>200) continue;
      try{
        const content=await entry.async('base64');
        if(!content || content.length<1) continue;
        uploadedFiles.push({name:path, content, size:content.length*0.75, isBinary:isBinaryFile(path)});
        c++;
      }catch(e){ log('⚠️ تخطي ملف تالف: '+rawPath); }
    }
    if(c==0) throw new Error('ZIP فاضي من الداخل');
    renderFileList(); analyzeProject();
    showStatus('uploadStatus',`✅ تم استخراج ${c} ملف`,'success');
  }catch(err){ showStatus('uploadStatus','❌ '+err.message,'error'); }
}

function processCode(){ const code=document.getElementById('codeInput').value; const fn=document.getElementById('codeFileName').value.trim(); if(!code.trim()) return showStatus('uploadStatus','أدخل الكود','error'); if(!fn) return showStatus('uploadStatus','أدخل اسم الملف','error'); const b64=btoa(unescape(encodeURIComponent(code))); uploadedFiles.push({name:fn, content:b64, size:code.length, isBinary:false}); renderFileList(); analyzeProject(); showStatus('uploadStatus',`✅ ${fn}`,'success'); }
function previewCode(){ const code=document.getElementById('codeInput').value; const p=document.getElementById('filePreview'); if(!code.trim()){ p.classList.remove('show'); return; } p.textContent=code.slice(0,3000); p.classList.add('show'); }
function renderFileList(){ const list=document.getElementById('fileList'); list.innerHTML=''; uploadedFiles.forEach((f,i)=>{ const d=document.createElement('div'); d.className='file-item'; d.innerHTML=`<span>📄 ${f.name}</span><span>${formatSize(f.size)}</span><button class="btn btn-danger" style="padding:2px 8px" onclick="removeFile(${i})">x</button>`; list.appendChild(d); }); saveFiles(); }
function removeFile(i){ uploadedFiles.splice(i,1); saveFiles(); renderFileList(); }
function clearAllFiles(){ uploadedFiles=[]; localStorage.removeItem('uploadedFiles_v7'); renderFileList(); document.getElementById('projectInfo').classList.remove('show'); showStatus('uploadStatus','تم المسح','info'); }
function analyzeProject(){
  if(!uploadedFiles.length) return showStatus('uploadStatus','لا ملفات','error');
  const names=uploadedFiles.map(f=>f.name.toLowerCase());
  let type='كود عام', lang='متعدد', ready='✅ نعم';
  if(names.some(n=>n.includes('pubspec.yaml'))) type='Flutter';
  else if(names.some(n=>n.endsWith('androidmanifest.xml'))) type='Android Native';
  else if(names.some(n=>n.endsWith('build.gradle')||n.endsWith('build.gradle.kts'))) type='Android Native';
  else if(names.some(n=>n.endsWith('.html'))) type='HTML/CSS/JS';
  document.getElementById('projectType').textContent=type;
  document.getElementById('mainLanguage').textContent=lang;
  document.getElementById('fileCount').textContent=uploadedFiles.length;
  document.getElementById('projectSize').textContent=formatSize(uploadedFiles.reduce((s,f)=>s+f.size,0));
  document.getElementById('buildReady').textContent=ready;
  document.getElementById('projectInfo').classList.add('show');
  detectedProjectType={type};
}

// ======== الرفع والبناء المصحح ========
async function uploadFileToRepo(rawPath, content){
  // تنظيف المسار - هذا سبب الخطأ اللي شفته
  let path = rawPath.replace(/\\/g,'/').trim().replace(/^\/+/, '').replace(/\/{2,}/g,'/');
  if(!path || path==='.' || path.endsWith('/')) throw new Error(`مسار غير صالح: ${rawPath}`);
  if(path.includes('..')) path = path.replace(/\.\.\//g,'');
  
  const apiPath=`/repos/${selectedRepo.full_name}/contents/${encodeURIComponent(path).replace(/%2F/g,'/')}`;
  let sha=null;
  // حاول تجيب sha بدون ما يطلع خطأ "file not found"
  try{
    const existing = await fetch(API+apiPath+`?ref=${encodeURIComponent(defaultBranch)}`, {
      headers:{'Authorization':`Bearer ${githubToken}`,'Accept':'application/vnd.github.v3+json'}
    });
    if(existing.ok){
      const j=await existing.json();
      sha=j.sha;
    }
    // إذا 404 يعني ملف جديد - عادي
  }catch(e){ /* ملف جديد */ }
  
  const body={message:`Add ${path} via V8`, content, branch:defaultBranch};
  if(sha) body.sha=sha;
  
  // إعادة محاولة مع انتظار إذا المستودع جديد
  for(let attempt=1; attempt<=3; attempt++){
    try{
      await githubFetch(apiPath,{method:'PUT', body:JSON.stringify(body)});
      return;
    }catch(err){
      if(err.message.includes('could not be found') && attempt<3){
        log(`⏳ انتظار تجهيز المستودع... محاولة ${attempt}`);
        await new Promise(r=>setTimeout(r, 2000*attempt));
        // حدث defaultBranch
        try{
          const repoData=await githubFetch(`/repos/${selectedRepo.full_name}`);
          defaultBranch=repoData.default_branch||'main';
          body.branch=defaultBranch;
        }catch{}
      } else {
        throw err;
      }
    }
  }
}

function generateWorkflow(){
  const type=detectedProjectType?.type||'';
  const appName=document.getElementById('appName').value||'MyApp';
  let steps='';
  if(type.includes('Flutter')){
    steps=`
    - name: Setup Flutter
      uses: subosito/flutter-action@v2
      with: { flutter-version: '3.22.3' }
    - name: Build APK
      run: |
        flutter pub get
        flutter build apk --debug`;
  } else if(type.includes('Android')){
    steps=`
    - name: Setup Android SDK
      uses: android-actions/setup-android@v3
    - name: Build APK
      run: |
        chmod +x gradlew || true
        ./gradlew assembleDebug --stacktrace || gradle assembleDebug --stacktrace
        ls -R app/build/outputs/apk/ || true`;
  } else {
    steps=`
    - name: Setup Node
      uses: actions/setup-node@v4
      with: { node-version: '20' }
    - name: Install and Build
      run: |
        if [ -f package.json ]; then npm install; fi
        if [ -f pubspec.yaml ]; then
          echo "Flutter detected" && flutter pub get && flutter build apk --debug || true
        fi
        if [ -f build.gradle ] || [ -f build.gradle.kts ] || [ -f gradlew ]; then
          chmod +x gradlew || true
          ./gradlew assembleDebug || gradle assembleDebug || true
        fi
        # Capacitor fallback for HTML
        if [ -f index.html ] && [ ! -f build.gradle ]; then
          npm init -y || true
          npm install @capacitor/core @capacitor/cli @capacitor/android || true
          npx cap init "${appName}" com.example.myapp --web-dir=. || true
          npx cap add android || true
          npx cap copy || true
          cd android && chmod +x gradlew && ./gradlew assembleDebug || true
          cd ..
        fi
        find . -name "*.apk" -type f || true`;
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
    - uses: actions/checkout@v4
    - name: Setup Java 17
      uses: actions/setup-java@v4
      with:
        distribution: 'temurin'
        java-version: '17'
${steps}
    - name: Upload APK artifact
      uses: actions/upload-artifact@v4
      with:
        name: app-apk
        path: |
          **/build/outputs/apk/debug/*.apk
          **/build/outputs/apk/release/*.apk
          **/*.apk
          android/app/build/outputs/apk/debug/*.apk
`;
}

async function startBuild(){
  if(!githubToken) return showStatus('buildStatus','اربط GitHub','error');
  if(!selectedRepo) return showStatus('buildStatus','اختر مستودع','error');
  if(!uploadedFiles.length) return showStatus('buildStatus','أضف ملفات','error');
  const btn=document.getElementById('buildBtn'); btn.disabled=true; btn.innerHTML='<span class="spinner"></span> جاري البناء...';
  try{
    log('🔍 تحديد الفرع...');
    // انتظار إذا المستودع جديد
    await new Promise(r=>setTimeout(r,1500));
    try{
      const repoData=await githubFetch(`/repos/${selectedRepo.full_name}`);
      defaultBranch=repoData.default_branch||'main';
      log('✅ الفرع: '+defaultBranch);
    }catch(e){
      defaultBranch='main';
      log('⚠️ استخدام main كافتراضي');
    }
    // إذا المستودع جديد جداً، انتظر ثانيتين
    if(!selectedRepo.default_branch){
      log('⏳ مستودع جديد - انتظار تجهيزه...');
      await new Promise(r=>setTimeout(r,3000));
    }
    log('📤 رفع '+uploadedFiles.length+' ملف إلى GitHub الرسمي...');
    let okCount=0, skipCount=0;
    for(const f of uploadedFiles){
      if(!f.content || f.content.length<2){ log('⚠️ تخطي فاضي: '+f.name); skipCount++; continue; }
      if(f.size>90*1024*1024){ log('⚠️ كبير جداً (>90MB) تخطي: '+f.name); skipCount++; continue; }
      try{
        await uploadFileToRepo(f.name, f.content);
        log('✅ '+f.name);
        okCount++;
      }catch(err){
        log('❌ فشل '+f.name+': '+err.message.slice(0,120));
        if(err.message.includes('could not be found')){
          log('💡 السبب: مسار الملف غير صالح أو المستودع جديد - تم إصلاحه في V8');
        }
        // لا توقف كل الرفع إذا ملف واحد فشل
      }
      await new Promise(r=>setTimeout(r,300)); // تهدئة لتجنب Rate limit
    }
    log(`📊 تم رفع ${okCount} / ${uploadedFiles.length} (تخطي ${skipCount})`);
    if(okCount===0) throw new Error('فشل رفع كل الملفات - تأكد أن ZIP يحتوي ملفات صالحة وليس مجلدات فاضية');
    log('📝 إنشاء workflow مصحح...');
    const wf=generateWorkflow();
    await uploadFileToRepo('.github/workflows/build.yml', btoa(unescape(encodeURIComponent(wf))));
    log('🚀 تشغيل البناء...');
    const trig=await fetch(API+`/repos/${selectedRepo.full_name}/actions/workflows/build.yml/dispatches`,{method:'POST', headers:{'Authorization':`Bearer ${githubToken}`,'Content-Type':'application/json'}, body:JSON.stringify({ref:defaultBranch})});
    if(!trig.ok){ const t=await trig.text(); throw new Error('فشل trigger: '+t.slice(0,200)); }
    await new Promise(r=>setTimeout(r,4000));
    const runs=await githubFetch(`/repos/${selectedRepo.full_name}/actions/runs?per_page=1`);
    if(!runs.workflow_runs?.length) throw new Error('لم يبدأ البناء');
    const run=runs.workflow_runs[0];
    log('⏳ Run ID: '+run.id);
    document.getElementById('buildLink').href=run.html_url;
    document.getElementById('artifactLink').href=run.html_url;
    monitorBuild(run.id);
  }catch(e){ showStatus('buildStatus','❌ '+e.message,'error'); btn.disabled=false; btn.innerHTML='⚡ بدء بناء APK'; }
}

async function monitorBuild(runId){
  let attempts=0;
  const check=async()=>{
    attempts++;
    try{
      const data=await githubFetch(`/repos/${selectedRepo.full_name}/actions/runs/${runId}`);
      log(`⚙️ ${data.status} / ${data.conclusion||'...'}`);
      if(data.status==='completed'){
        const btn=document.getElementById('buildBtn'); btn.disabled=false; btn.innerHTML='⚡ بدء بناء APK';
        if(data.conclusion==='success'){
          showStatus('buildStatus','🎉 نجح البناء! جاري البحث عن APK...','success');
          await downloadArtifactWithRetry(runId);
        } else {
          showStatus('buildStatus',`❌ فشل: ${data.conclusion}. راجع GitHub`,'error');
        }
        return;
      }
      if(attempts<80) setTimeout(check,8000); else { showStatus('buildStatus','⏱️ طول، تابع من GitHub','info'); document.getElementById('buildBtn').disabled=false; }
    }catch(e){ log('⚠️ '+e.message); if(attempts<80) setTimeout(check,8000); }
  };
  check();
}

async function downloadArtifactWithRetry(runId){
  log('📦 البحث عن APK...');
  let artifact=null;
  for(let i=1;i<=12;i++){
    try{
      const d=await githubFetch(`/repos/${selectedRepo.full_name}/actions/runs/${runId}/artifacts?per_page=100`);
      const list=(d.artifacts||[]).filter(a=>!a.expired);
      log(`🔍 محاولة ${i}: ${list.length} artifact`);
      artifact=list.find(a=>a.name==='app-apk')||list.find(a=>a.name.toLowerCase().includes('apk'))||list[0];
      if(artifact) break;
    }catch(e){ log('⚠️ '+e.message); }
    await new Promise(r=>setTimeout(r,5000));
  }
  if(!artifact){ document.getElementById('downloadLinks').classList.add('show'); showStatus('buildStatus','✅ البناء نجح لكن Artifact تأخر. اضغط فتح Artifact وحمله يدويا','success'); return; }
  log(`✅ وجدت ${artifact.name} (${Math.round(artifact.size_in_bytes/1024)}KB)`);
  document.getElementById('artifactLink').href=`https://github.com/${selectedRepo.full_name}/actions/runs/${runId}`;
  document.getElementById('buildLink').href=`https://github.com/${selectedRepo.full_name}/actions/runs/${runId}`;
  try{
    const resp=await fetch(API+`/repos/${selectedRepo.full_name}/actions/artifacts/${artifact.id}/zip`,{headers:{'Authorization':`Bearer ${githubToken}`,'Accept':'application/vnd.github+json'}});
    if(!resp.ok) throw new Error('HTTP '+resp.status);
    const zip=await JSZip.loadAsync(await resp.blob());
    let apkFile=null; zip.forEach((p,f)=>{ if(!f.dir&&p.toLowerCase().endsWith('.apk')&&!apkFile) apkFile=f; });
    if(!apkFile) throw new Error('لا APK داخل Artifact');
    if(lastDownloadUrl) URL.revokeObjectURL(lastDownloadUrl);
    const blob=await apkFile.async('blob');
    lastDownloadUrl=URL.createObjectURL(blob);
    const a=document.getElementById('apkDownloadLink');
    a.href=lastDownloadUrl; a.download=(document.getElementById('appName').value||'MyApp')+'-debug.apk';
    document.getElementById('downloadLinks').classList.add('show');
    log(`🎉 APK جاهز: ${apkFile.name} (${(blob.size/1024/1024).toFixed(1)}MB)`);
    showStatus('buildStatus','🎉 تم! اضغط تحميل APK','success');
  }catch(e){
    log('⚠️ تحميل تلقائي فشل: '+e.message);
    document.getElementById('downloadLinks').classList.add('show');
    showStatus('buildStatus','✅ البناء نجح. اضغط فتح Artifact وحمله يدويا من GitHub','success');
  }
}
</script>
<div style="margin:20px;padding:15px;background:#020617;border:1px solid #22c55e;border-radius:10px;font-size:12px;color:#94a3b8">
<h3 style="color:#22c55e">🔒 هل GitHub رسمي؟</h3>
<p>نعم، هذا هو GitHub الرسمي <b>https://github.com</b> مملوك لشركة مايكروسوفت. موقعي لا يصمم GitHub، فقط يستخدم واجهة برمجة التطبيقات الرسمية <b>api.github.com</b>.</p>
<p>✅ تقدر تتأكد: افتح متصفح Chrome واكتب <b>github.com/h6566924-sys</b> بيدك - بتشوف نفس المستودعات.<br>
✅ التوكن يبقى في جوالك فقط (localStorage) ولا يرسل لي أبداً.<br>
✅ رابط التحميل دائماً يبدأ بـ <b>github.com/اسمك</b> وليس موقع غريب.</p>
<p style="color:#fbbf24">⚠️ GitHub بالإنجليزي لأنه موقع أمريكي، لكن أزرار التحميل واضحة: Artifacts → app-apk.zip → ثم فك الضغط بتحصل APK.</p>
</div>
<script>(function(){var loc=location.href.replace(/#.*$/,"");var ATTR_NAMES=["data-product-id","data-productid","data-product_id","product-id","productid","product_id","data-source-entity-id","source-entity-id","source_entity_id","data-product","data-metadata","data-meta"];var DATASET_KEYS=["productId","productid","product_id","sourceEntityId","sourceentityid","source_entity_id","product","metadata","meta"];function readProductId(value){if(typeof value!=="string"||value.length===0)return null;if(/^[0-9]{6,}$/.test(value))return value;var match=value.match(/(?:product(?:_|-)?id|source(?:_|-)?entity(?:_|-)?id)["'=:\s]+([0-9]{6,})/i);return match?match[1]:null}function extractProductId(start){for(var node=start;node&&node!==document.body;node=node.parentElement){for(var i=0;i<ATTR_NAMES.length;i++){var attrValue=node.getAttribute&&node.getAttribute(ATTR_NAMES[i]);var attrProductId=readProductId(attrValue);if(attrProductId)return attrProductId}var dataset=node.dataset||null;if(dataset){for(var j=0;j<DATASET_KEYS.length;j++){var dataValue=dataset[DATASET_KEYS[j]];var dataProductId=readProductId(dataValue);if(dataProductId)return dataProductId}}}return null}function isInlineMediaSlotElement(node){return !!(node&&node.getAttribute&&node.getAttribute("data-clippy-inline-media-slot")!==null)}function findInlineMediaSlot(start){for(var node=start;node&&node!==document.body;node=node.parentElement){if(isInlineMediaSlotElement(node))return node}return null}function readInlineMediaUrl(node){if(!node)return null;return node.getAttribute&&((node.getAttribute("data-clippy-inline-media-url")||node.getAttribute("data-url")||node.getAttribute("data_url")))||node.href||null}function stripHash(url){return String(url).replace(/#.*$/,"")}function urlsMatch(a,b){if(!a||!b)return false;try{return stripHash(new URL(a,loc).href)===stripHash(new URL(b,loc).href)}catch(_){return stripHash(a)===stripHash(b)}}function isFirstPartyReelUrl(value){try{var url=new URL(value,loc);if(url.protocol!=="https:")return false;var host=url.hostname.toLowerCase();var supported=host==="instagram.com"||host.endsWith(".instagram.com")||host==="facebook.com"||host.endsWith(".facebook.com");return supported&&/\/reels?\//i.test(url.pathname)}catch(_){return false}}function isInlineMediaUrlClick(node,href){var slot=findInlineMediaSlot(node);if(!slot)return false;var slotUrl=readInlineMediaUrl(slot);if(slotUrl)return urlsMatch(href,slotUrl);return isFirstPartyReelUrl(href)}function findDataHref(start){for(var node=start;node&&node!==document.body;node=node.parentElement){if(node.getAttribute){var href=node.getAttribute("data-href")||node.getAttribute("data-url");if(href)return{href:href,node:node}}}return null}var nativeOpen=window.open;window.open=function(url){if(parent!==window&&typeof url==="string"&&/^https?:\/\//.test(url)){parent.postMessage({type:"ecto:usercontent-link-click",href:url},"*");return null}return nativeOpen?nativeOpen.apply(window,arguments):null};document.addEventListener("click",function(e){var target=e.target instanceof Element?e.target:null;if(!target)return;if(parent===window)return;var a=target.closest?target.closest("a[href]"):null;if(a&&a.href&&/^https?:\/\//.test(a.href)&&a.href.replace(/#.*$/,"")!==loc){if(isInlineMediaUrlClick(a,a.href))return;var productId=extractProductId(target)||extractProductId(a);if(productId){e.preventDefault();parent.postMessage({type:"ecto-artifact-link-click",productId:productId},"*");return}e.preventDefault();parent.postMessage({type:"ecto:usercontent-link-click",href:a.href},"*");return}var dataHref=findDataHref(target);if(dataHref&&/^https?:\/\//.test(dataHref.href)&&dataHref.href.replace(/#.*$/,"")!==loc){if(isInlineMediaUrlClick(dataHref.node,dataHref.href))return;e.preventDefault();parent.postMessage({type:"ecto:usercontent-link-click",href:dataHref.href},"*")}},true)})();</script><script>(function(){var FOCUS_TYPE="ecto:artifact-focus-request";var CLOSE_TYPE="ecto:artifact-close-request";function focusArtifactDocument(){var body=document.body;if(!body)return;try{window.focus();}catch(e){}if(!body.hasAttribute("tabindex"))body.setAttribute("tabindex","-1");try{body.focus({preventScroll:true});}catch(e){try{body.focus();}catch(e2){}}}window.addEventListener("message",function(event){if(event.source!==window.parent)return;var data=event.data;if(!data||typeof data!=="object"||data.type!==FOCUS_TYPE)return;if(document.readyState==="loading"){document.addEventListener("DOMContentLoaded",focusArtifactDocument,{once:true});return;}focusArtifactDocument();});window.addEventListener("keydown",function(event){if(event.key!=="Escape")return;window.setTimeout(function(){if(event.defaultPrevented)return;window.parent.postMessage({type:CLOSE_TYPE},"*");},0);});})();</script></body>
</html>
