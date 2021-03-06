# BaseProject ( with MVVM Clean Architecture )
Clean Architecture는 높은 수준의 추상화와, 그리고 잘 정의된 responsibilities과 느슨하게 결합된 방식으로 서로 다른 계층의 코드를 분리할 수 있게 해준다.
따라서 코드를 읽으면 추가적인 수정과 테스트가 훨씬 쉬워진다. 엔터프라이즈급 대형 프로젝트는 보통 개발자 팀에 의해 개발된다.
개발자마다 프로젝트의 다른 패키지나 모듈을 개발한다. 때때로 개발자들은 다른 장소에서 일하고 있다. 한 개발자는 다른 개발자가 사용 사례를 구현하는 방법을 알 필요가 없거나 알 필요가 없을 수 있다.
Clean Architecture에서 통신은 공공 인터페이스를 통해 이루어진다. 그래서 개발팀에 딱 맞는 거다. Android Development의 최신 트렌드는 Kotlin 멀티플랫폼 애플리케이션 개발이다. 
Kotlin 멀티플랫폼으로 우리는 안드로이드 프로젝트의 상당 부분을 ios와 웹 프로젝트에 다시 사용할 수 있다. 만약 당신이 기꺼이 Kotlin 멀티플랫폼을 사용한다면, 
Clean Architecture을 따르는 것은 매우 유용하다.
**MVVM Clean Architecture로 변환하려면 repository와 ViewModels 구성 요소 사이에 UseCase 라는 다른 구성 요소를 추가해야 한다.
UseCase는 논리 실행 클래스다. 사용자가 트리거할 수 있는 동작을 정의한다. 어떤 개발자들은 그들을 상호작용자(interactors)로 명명한다. 
Clean Architecture를 사용할 때, 우리는 3개의 계층을 프리젠테이션 계층 또는 애플리케이션 계층, 도메인 계층 및 데이터 계층으로 인식할 수 있다.**
```
프레젠테이션 계층은 화면에 사물을 표시하고 사용자 클릭을 듣는 등 사용자와 상호 작용하는 계층이다.
이 계층은 activities, fragments,view models, adapters 및 dependency injection related classes and interfaces.를 포함한다.
Clean Architecture에서 ViewModels는 repository 클래스와 직접 상호작용하지 않아야 한다.
ViewModels는은 UseCase는와 상호 작용해야 하며, UseCase는는 repository 상호 작용해야 한다.
```
```
도메인 계층은 앱의 비즈니스 로직을 포함한다. 여기서는 UseCase 클래스를 유지하며, 각 클래스는 특정 작업을 가지고 있다. 
우리는 또한 도메인 계층에 대한 repository 인터페이스를 포함한다.
순수한 코틀린을 사용하여 작성된 경우 도메인 계층에 entity classe를 추가할 수도 있다.
entity classe에 안드로이드 특정 종속성이 있는 경우 데이터 계층에 추가해야 한다. 
데이터 계층에는 모든 데이터 소스와 그 구현에 대한 추상적인 정의가 포함되어 있다.
```
#
## TMDB Client App
```
https://www.themoviedb.org/
https://developers.themoviedb.org/3
```
