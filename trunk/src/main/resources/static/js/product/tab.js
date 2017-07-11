var JUI = JUI || {};

(function(param) {
    var global = param.global,
        $      = param.$;
    
    JUI.verticalSlide = function (container, options) {
        
        if (!container.length) {
            return;
        }
        
        var detect = {},
            config = {
                isSelected : 0,
                speed : 400
            },
            active = 'is-selected';
        
        $.extend(config, options);
        
        function init() {
            setup();
            isSelected();
        }
        
        function isSelected() {
            detect.tabListItem.removeClass(active);
            detect.viewContents.removeClass(active);
            detect.tabListItem.eq(config.isSelected).addClass(active);
            detect.viewContents.eq(config.isSelected).addClass(active);
        }
        
        function setup() {
            
            detect.tabContainer = container.find('.tab');
            detect.tabListItem  = detect.tabContainer.find('li');
            detect.viewBox      = container.find('.view-box');
            detect.viewContents = detect.viewBox.find('.list-wrap');
            detect.tabLength    = detect.tabListItem.length;
            detect.max          = detect.tabLength - 1;
            detect.currentIndex = config.isSelected;
            detect.height       = detect.viewContents.height();
            
            // 탭 리스트 인덱스 설정
            detect.tabListItem.each(function (index) {
                $(this).find('a').data('index', index);
            });
            
        }
        
        function direction(selectedIndex) {
            return detect.currentIndex < selectedIndex ? 'goToUp' : 'goToDown';
        }
        
        function slideStarting(selectedIndex, speed) {
            
            if ((detect.currentIndex == selectedIndex) || (selectedIndex > detect.max)) {
                return;
            }
            
            if (detect.viewContents.is(':animated')) {
                return;
            }
            
            var position = direction(selectedIndex),
                offset;
            
            switch(position) {
                case 'goToUp' :
                    offset = detect.height;
                    break;
                case 'goToDown' :
                    offset = -detect.height;
            }
            
            detect.viewContents.eq(selectedIndex).css({'top': offset}).addClass(active);
            detect.viewContents.eq(selectedIndex).animate({'top' : 0}, speed);
            
            detect.viewContents.eq(detect.currentIndex).animate({'top': -offset}, speed, function () {
                slideEnding(selectedIndex);
            });
            
        }
        
        function slideEnding(selectedIndex) {
            
            detect.tabListItem.eq(detect.currentIndex).removeClass(active);
            detect.viewContents.eq(detect.currentIndex).removeClass(active);
            detect.tabListItem.eq(selectedIndex).addClass(active);
            detect.viewContents.removeAttr('style');
            
            detect.currentIndex = selectedIndex;
        }
        
        init();
        
        detect.tabListItem.on('click.banner', ' > a', function () {
            slideStarting($(this).data('index'), config.speed);
            return false;
        });
        
    };
    
}({global: window, $: window.jQuery}));

$(function () {
    /**
     * @param1 필수, @param2 옵션
     * @param1 @type $('selector') :슬라이더 컨테이너 박스
     * @ppram2 @type {} : 객체리터럴
     * {isSelected:0, speed: 400} : 처음 활성화시켜놓을 요소, 애니메이션 속도
     * ex) JUI.verticalSlide($('.slide-v'), {isSelected: 1, speed: 400});
     **/
    JUI.verticalSlide($('.slide-v'));
});