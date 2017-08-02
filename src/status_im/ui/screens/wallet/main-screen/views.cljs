(ns status-im.ui.screens.wallet.main-screen.views
  (:require-macros [status-im.utils.views :refer [defview]])
  (:require [clojure.string :as string]
            [re-frame.core :as rf]
            [status-im.components.common.common :as common]
            [status-im.components.drawer.view :as drawer]
            [status-im.components.react :as rn]
            [status-im.components.toolbar-new.view :as toolbar]
            [status-im.components.toolbar-new.actions :as act]
            [status-im.i18n :as i18n]
            [status-im.utils.listview :as lw]
            [status-im.utils.platform :refer [platform-specific]]
            [status-im.ui.screens.wallet.main-screen.styles :as st]))

(defn toolbar-view [transactions]
  [toolbar/toolbar
   {:nav-action       (act/hamburger drawer/open-drawer)
    :background-color st/toolbar-background}])

(defn action-buttons []
  [rn/view {:style st/action-buttons-container}
   [rn/view {:style st/action-button}
    [rn/text {:style st/action-button-text} "Send"]]
   [rn/view {:style st/action-button-center}
    [rn/text {:style st/action-button-text} "Receive"]]
   [rn/view {:style st/action-button}
    [rn/text {:style st/action-button-text} "Exchange"]]])

(defn main-section []
  [rn/view {:style st/main-section}
   [rn/view {:style st/main-section-top-container}
    [rn/text {:style st/wallet-name} "Main wallet"]
    [rn/image {:source {:uri :icon_dots_horizontal_white}
               :style st/wallet-options-icon}]]
   [rn/view {:style st/total-balance-container}
    [rn/view {:style st/total-balance}
     [rn/text {:style st/total-balance-value} "12.43"]
     [rn/text {:style st/total-balance-currency} "USD"]]
    [rn/view {:style st/value-variation}
     [rn/text {:style st/value-variation-title} "Total value"]
     [rn/view {:style st/today-variation-container}
      [rn/text {:style st/today-variation} "+5.433%"]]]
    [action-buttons]]])

(defn asset-list-item [[id {:keys [currency amount] :as row}]]
  [rn/view {:style st/asset-item-container}
   [rn/image {:source {:uri :icon_close_dark}
              :style st/asset-item-currency-icon}]
   [rn/view {:style st/asset-item-value-container}
    [rn/text {:style st/asset-item-value} (str amount)]
    [rn/text {:style      st/asset-item-currency
              :uppercase? true}
     id]]
   [rn/image {:source {:uri :icon_back_gray}
              :style st/asset-item-details-icon}]])

(defn render-separator-fn [assets-count]
  (fn [_ row-id _]
    (rn/list-item
     ^{:key row-id}
     [common/separator {} st/asset-list-separator])))

(defn render-row-fn [row _ _]
  (rn/list-item
   [rn/touchable-highlight {:on-press #()}
    [rn/view
     [asset-list-item row]]]))

(defn asset-section []
  (let [assets {"eth" {:currency :eth :amount 0.445}
                  "snt" {:currency :snt :amount 1}
                  "sgt" {:currency :sgt :amount 125455.555}
                  "gnt" {:currency :gnt :amount 0.024794}
                  "sna" {:currency :snt :amount 1}}]
    [rn/view {:style st/asset-section}
     [rn/text {:style st/asset-section-title} "Assets"]
     [rn/list-view {:style           st/asset-list
                    :dataSource      (lw/to-datasource assets)
                    :renderSeparator (render-separator-fn (count assets))
                    :renderRow       render-row-fn}]]))



(defview wallet []
  []
  [rn/view {:style st/wallet-container}
   [toolbar-view]
   [rn/scroll-view
    [main-section]
    [asset-section]]])
