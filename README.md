# CallRecorder
## Предупреждение
_Google запретил запись звонков с версии Android 10, приложение создавалось для версии Android 9._

## Описание
Приложение для записи звонков, позволяющее пользователю набирать номер, выполнять звонок и записывать разговор. Запись разговора сохраняется в папку "storage/emulated/0/CallRecorder" как файл с именем "call.mp3". 

## Работа приложения
На скриншотах изображена главная страница приложения, где сверху указано название приложения, а посередине экрана находится поле для ввода номера и кнопка вызова. Пользователь с клавиатуры вводит номер в соответствующее поле и с помощью кнопки начинает звонок. Приложение отслеживает, когда собеседник берет трубку, и начинает запись, а после того, как кто-то из собеседников завершает звонок, приложение останавливает запись и сохраняет файл с записью разговора.

<image src="/tests and screenshots/screenshot 1.png" alt="Главная страница CallRecorderApp" width="300">
<image src="/tests and screenshots/screenshot 2.png" alt="Главная страница CallRecorderApp, ввод номера" width="300">

В папке "tests and screenshots" находится файл ["emulator test.mp4"](https://github.com/SofyaAksenova/CallRecorder/blob/main/tests%20and%20screenshots/emulator%20test.mp4) с записью экрана, демонстрирующий работу приложения на эмуляторе устройства с версией Android 9. 

## Установка
Для установки приложения необходимо скачать файл "callrecorder.apk" на Android устройство и установить приложение.
