; Script generated by the Inno Setup Script Wizard.
; SEE THE DOCUMENTATION FOR DETAILS ON CREATING INNO SETUP SCRIPT FILES!

[Setup]
AppId={{application}}
AppName=ProjectIntegration
AppVersion=1.0
AppVerName=ProjectIntegration 1.0
AppPublisher=Eletra Energy Solutions
;AppPublisherURL=ProjectIntegration
;AppSupportURL={#MyAppURL}
;AppUpdatesURL={#MyAppURL}
DefaultDirName={localappdata}\ProjectIntegration
DisableStartupPrompt=Yes
DisableDirPage=Yes
DisableProgramGroupPage=Yes
DisableReadyPage=Yes
DisableFinishedPage=Yes
DisableWelcomePage=Yes
DefaultGroupName=Eletra Energy Solutions
;Optional License
LicenseFile=
;WinXP or above
OutputBaseFilename=setupMinVersion=0,5.1
;MinVersion=0,5.1 
OutputBaseFilename=ProjectIntegration-1.0
Compression=lzma
SolidCompression=yes
PrivilegesRequired=lowest
SetupIconFile=projetoIntegracaoFront\ProjectIntegration.ico
UninstallDisplayIcon={app}\ProjectIntegration.ico
UninstallDisplayName=ProjectIntegration
WizardImageStretch=No
WizardSmallImageFile=ProjectIntegration-setup-icon.bmp
ArchitecturesInstallIn64BitMode=
UsePreviousGroup=no
UsePreviousAppDir=no

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"
Name: "brazilianportuguese"; MessagesFile: "compiler:Languages\BrazilianPortuguese.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Files]
Source: "ProjectIntegration\ProjectIntegration.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "ProjectIntegration\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs
; NOTE: Don't use "Flags: ignoreversion" on any shared system files

[Icons]
Name: "{group}\ProjectIntegration"; Filename: "{app}\ProjectIntegration.exe"
Name: "{commondesktop}\ProjectIntegration"; Filename: "{app}\ProjectIntegration.exe"; IconFilename: "{app}\ProjectIntegration.ico"; Check: returnTrue()

[Run]                                                                                         
Filename: "{localappdata}\ProjectIntegration\uninstall.exe"; Flags: skipifdoesntexist           
Filename: "{app}\ProjectIntegration.exe"; Parameters: "-Xappcds:generatecache"; Check: returnFalse()
Filename: "{app}\ProjectIntegration.exe"; Description: "{cm:LaunchProgram,ProjectIntegration}"; Flags: nowait postinstall skipifsilent; Check: returnTrue()
Filename: "{app}\ProjectIntegration.exe"; Parameters: "-install -svcName ""ProjectIntegration"" -svcDesc ""ProjectIntegration"" -mainExe ""ProjectIntegration.exe""  "; Check: returnFalse()
                  
[InstallDelete]  
Type: files; Name: "{commondesktop}\ProjectIntegration.lnk"; 

[UninstallRun]
Filename: "{app}\ProjectIntegration.exe "; Parameters: "-uninstall -svcName ProjectIntegration -stopOnUninstall"; Check: returnFalse()  

[Code]
function returnTrue(): Boolean;
begin
  Result := True;
end;

function returnFalse(): Boolean;
begin
  Result := False;
end;

function InitializeSetup(): Boolean;
begin
// Possible future improvements:
//   if version less or same => just launch app
//   if upgrade => check if same app is running and wait for it to exit
//   Add pack200/unpack200 support? 
  Result := True;
end;