@echo off
::ת����ǰ�̷�
%~d0
::�򿪵�ǰĿ¼
cd %~dp0
::��������JAR����·��
set MainJar=alipay.jar
::������JAR����·��
set ExternalJar=alipaysdk.jar
::������JAR������������
set packageName=com
echo =========== start combin ==============
::��ѹ��������
jar -xf %ExternalJar%
::�ϲ���JAR��
jar -uf %MainJar% %packageName%
jar -uf %MainJar% HttpUtils
::������б�Ķ��������Խ��źϲ������磺
::jar -uf %MainJar% %packageName2%
::jar -uf %MainJar% org
::jar -uf %MainJar% cn
echo =========== over ==============
echo �ϲ��ɹ�,��һ�¾ͽ�����--СQ
pause